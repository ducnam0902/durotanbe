package com.durotan.services.impl;

import com.durotan.daodto.ProductDto;
import com.durotan.entity.Product;
import com.durotan.exception.ResourceNotFoundException;
import com.durotan.mapper.ProductMapper;
import com.durotan.repository.ProductCategoryRepository;
import com.durotan.repository.ProductRepository;
import com.durotan.services.ProductServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServicesImpl implements ProductServices {
    private ProductRepository productRepository;
    private ProductCategoryRepository productCategoryRepository;
    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product newProduct = ProductMapper.mapToProduct(productDto);
        Product savedProduct = productRepository.save(newProduct);
        return ProductMapper.mapToProductDto(savedProduct);
    }

    @Override
    public ProductDto getProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product is not exists with a given id" + productId));
        return ProductMapper.mapToProductDto(product);
    }

    @Override
    public List<ProductDto> getAllProduct() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> ProductMapper.mapToProductDto(product))
                .collect(Collectors.toList());
    }
}
