package com.durotan.services.impl;

import com.durotan.daodto.ProductItemDto;
import com.durotan.daodto.ProductResultDto;
import com.durotan.daodto.QuanityGroupDto;
import com.durotan.daodto.SizeGroupDto;
import com.durotan.entity.Color;
import com.durotan.entity.Product;
import com.durotan.entity.ProductItem;
import com.durotan.entity.Size;
import com.durotan.exception.ResourceNotFoundException;
import com.durotan.mapper.ProductItemMapper;
import com.durotan.repository.ColorRepository;
import com.durotan.repository.ProductItemRepository;
import com.durotan.repository.ProductRepository;
import com.durotan.repository.SizeRepository;
import com.durotan.services.ProductItemServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductItemServicesImpl implements ProductItemServices {
    private ProductItemRepository productItemRepository;
    private SizeRepository sizeRepository;
    private ColorRepository colorRepository;
    private ProductRepository productRepository;


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
        return productItems.stream().map(productItem -> ProductItemMapper.mapToProductItemDto(productItem))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductResultDto> getFeaturedProduct() {
        List<ProductResultDto> productResultList = new ArrayList<>();
        List<Product> productItems = productRepository.findTop4ByOrderByIdDesc();
        productItems.forEach(product -> {
            ProductResultDto newProductResult = new ProductResultDto();
            newProductResult.setName(product.getName());
            List<ProductItem> listProducts = productItemRepository.findByProductId(product.getId());
            listProducts.forEach(item -> {
                System.out.println(item.getProduct().getName());
            });
            productResultList.add(newProductResult);
        });



        return productResultList;
    }
}
