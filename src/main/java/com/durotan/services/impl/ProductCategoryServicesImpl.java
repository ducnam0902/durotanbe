package com.durotan.services.impl;

import com.durotan.daodto.ProductCategoryDto;
import com.durotan.entity.ProductCategory;
import com.durotan.exception.ResourceNotFoundException;
import com.durotan.mapper.ProductCategoryMapper;
import com.durotan.repository.ProductCategoryRepository;
import com.durotan.services.ProductCategoryServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProductCategoryServicesImpl implements ProductCategoryServices {
    private ProductCategoryRepository productCategoryRepository;

    public ProductCategoryServicesImpl(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    @Override
    public ProductCategoryDto createProductCategory(ProductCategoryDto productCategoryDto) {
        ProductCategory newProductCategory = ProductCategoryMapper.mapToProductCategory(productCategoryDto);
        ProductCategory savedProductCategory = productCategoryRepository.save(newProductCategory);
        return ProductCategoryMapper.mapToProductCategoryDto(savedProductCategory);
    }

    @Override
    public ProductCategoryDto getProductCategoryById(Long productCategoryId) {
        ProductCategory productCategory = productCategoryRepository.findById(productCategoryId).orElseThrow(() -> new ResourceNotFoundException("Product Category is not exists with a given id " + productCategoryId));
        return ProductCategoryMapper.mapToProductCategoryDto(productCategory);
    }

    @Override
    public List<ProductCategoryDto> getAllProductCategory() {
        List<ProductCategory> productCategories = productCategoryRepository.findAll();
        return productCategories.stream().map(productCategory -> ProductCategoryMapper.mapToProductCategoryDto(productCategory))
                .collect(Collectors.toList());
    }
}
