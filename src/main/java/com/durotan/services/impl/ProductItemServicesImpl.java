package com.durotan.services.impl;

import com.durotan.daodto.*;
import com.durotan.entity.*;
import com.durotan.exception.ResourceNotFoundException;
import com.durotan.mapper.ProductItemMapper;
import com.durotan.repository.*;
import com.durotan.services.ProductItemServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductItemServicesImpl implements ProductItemServices {
    private ProductItemRepository productItemRepository;
    private SizeRepository sizeRepository;
    private ColorRepository colorRepository;
    private ProductRepository productRepository;
    private ProductCategoryRepository categoryRepository;


    @Override
    public ProductItemDto createProductItem(ProductItemDto productItemDto) {
        Size size = sizeRepository.findById(productItemDto.getSize())
                .orElseThrow(() -> new ResourceNotFoundException("Size is not exists with a given id" + productItemDto.getSize()));
        Color color = colorRepository.findById(productItemDto.getColor())
                .orElseThrow(() -> new ResourceNotFoundException("Color is not exists with a given id" + productItemDto.getColor()));
        Product product = productRepository.findById(productItemDto.getProduct())
                .orElseThrow(() -> new ResourceNotFoundException("Product is not exists with a given id" + productItemDto.getProduct()));
        ProductItem newProductItem = ProductItemMapper.mapToProductItem(productItemDto, size, color, product);
        ProductItem savedProductItem = productItemRepository.save(newProductItem);
        return ProductItemMapper.mapToProductItemDto(savedProductItem);
    }

    @Override
    public ProductItemDto getProductItemById(Long productItemId) {
        ProductItem productItem = productItemRepository.findById(productItemId)
                .orElseThrow(() -> new ResourceNotFoundException("Product item is not exists with a given id" + productItemId));

        return ProductItemMapper.mapToProductItemDto(productItem);
    }

    @Override
    public List<ProductItemDto> getAllProductItem() {
        List<ProductItem> productItems = productItemRepository.findAll();
        return productItems.stream().map(ProductItemMapper::mapToProductItemDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductResultDto> getFeaturedProduct() {
        List<ProductResultDto> productResultList = new ArrayList<>();
        List<Product> productItems = productRepository.findTop4ByOrderByIdDesc();

        productItems.forEach(product -> {
            List<Long> allColorProducts = productItemRepository.findAllColorByProductId(product.getId());
            ProductResultDto aProduct = new ProductResultDto();
            List<ColorGroupDto> groupColor = new ArrayList<>();
            allColorProducts.forEach(colorProduct -> {
                List<ProductItem> productByColor = productItemRepository.findAllByProductIdAndColorId(product.getId(), colorProduct);
                ColorGroupDto aColorGroup = new ColorGroupDto();
                aColorGroup.setColorName(productByColor.get(0).getColors().getColorName());
                aColorGroup.setImages(List.of(productByColor.get(0).getImage1(), productByColor.get(0).getImage2()));
                List<SizeGroupDto> sizeGroupList = new ArrayList<>();
                productByColor.forEach(singleProduct -> {
                    SizeGroupDto sizeItem = new SizeGroupDto();
                    sizeItem.setSizeName(singleProduct.getSize().getSizeName());
                    sizeItem.setQuanityInStock(singleProduct.getQuanityInStock());
                    sizeGroupList.add(sizeItem);
                });
                aColorGroup.setSize(sizeGroupList);
                groupColor.add(aColorGroup);
            });
            aProduct.setPrice(product.getPrice());
            aProduct.setCategory(product.getCategory().getCategoryName());
            aProduct.setName(product.getName());
            aProduct.setQuanity(groupColor);
            productResultList.add(aProduct);
        });

        return productResultList;
    }

    @Override
    public List<ProductResultDto> getFilterProduct(FilterCriteriaDto conditions) {
        List<ProductResultDto> productResultList = new ArrayList<>();
        if(conditions.getCategoryName() != null){
            ProductCategory category = categoryRepository.findByCategoryName(conditions.getCategoryName());
            List<Product> products = productRepository.findByCategory(category);
            List<Color> colors = colorRepository.findByColorNameIn(conditions.getColorName());
            products.forEach(product -> {
                ProductResultDto productItem = new ProductResultDto();
                productItem.setName(product.getName());
                productItem.setCategory(product.getCategory().getCategoryName());
                productItem.setPrice(product.getPrice());
                List<ColorGroupDto> colorGroup = new ArrayList<>();
                colors.forEach(color -> {
                    ColorGroupDto singleColor = new ColorGroupDto();

                    List<SizeGroupDto> sizeGroup = new ArrayList<>();
                    List<ProductItem> listProduct = productItemRepository.findAllByProductIdAndColorId(product.getId(), color.getId());
                    listProduct.forEach(productItem1 -> {
                        SizeGroupDto singleSize = new SizeGroupDto();
                        singleSize.setSizeName(productItem1.getSize().getSizeName());
                        singleSize.setQuanityInStock(productItem1.getQuanityInStock());
                        sizeGroup.add(singleSize);
                    });
                    singleColor.setColorName(color.getColorName());
                    singleColor.setSize(sizeGroup);
                    if(!listProduct.isEmpty()){
                        singleColor.setImages(List.of(
                                listProduct.get(0).getImage1(),
                                listProduct.get(0).getImage2()
                        ));
                    }

                    colorGroup.add(singleColor);

                });
                productItem.setQuanity(colorGroup);
                productResultList.add(productItem);
            });
        }
        return productResultList;
    }
}
