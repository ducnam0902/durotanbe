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

import static com.durotan.mapper.ProductResultMapper.mapToProductResultListDto;

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
        List<Product> products = productRepository.findTop4ByOrderByIdDesc();

        products.forEach(product -> {
            List<ProductItem> productItems = productItemRepository.findAllByProduct(product);
            List<ProductResultDto> productResultDtosList = mapToProductResultListDto(productItems);
            productResultList.addAll(productResultDtosList);
        });

        return productResultList;
    }

    @Override
    public List<ProductResultDto> getFilterProduct(FilterCriteriaDto conditions) {

        if(conditions.getCategoryName().isBlank() && conditions.getColorName().size() == 0) {
            List<ProductItem> listProduct = productItemRepository.findAll();
            return mapToProductResultListDto(listProduct);
        }

        if(conditions.getCategoryName() != null && conditions.getColorName().size() == 0){
            ProductCategory category = categoryRepository.findByCategoryName(conditions.getCategoryName());
            List<Product> products = productRepository.findByCategory(category);
            List<ProductItem> totalProductItemList = new ArrayList<>();
            products.forEach(product -> {
                List<ProductItem> productItemList = productItemRepository.findAllByProduct(product);
                totalProductItemList.addAll(productItemList);
            });
            return mapToProductResultListDto(totalProductItemList);
        }

        if(conditions.getCategoryName() == null && conditions.getColorName().size() != 0){
            List<Color> colors = colorRepository.findByColorNameIn(conditions.getColorName());
            List<ProductItem> listProduct = productItemRepository.findByColorsIn(colors);
            return mapToProductResultListDto(listProduct);
        }

        ProductCategory category = categoryRepository.findByCategoryName(conditions.getCategoryName());
        List<Product> products = productRepository.findByCategory(category);
        List<Color> colors = colorRepository.findByColorNameIn(conditions.getColorName());
        List<ProductItem> listProduct = productItemRepository.findByProductInAndColorsIn(products,colors );

        return mapToProductResultListDto(listProduct);
    }
}
