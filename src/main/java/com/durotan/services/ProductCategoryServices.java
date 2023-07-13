package com.durotan.services;

import com.durotan.daodto.ProductCategoryDto;

import java.util.List;

public interface ProductCategoryServices {
    ProductCategoryDto createProductCategory(ProductCategoryDto productCategoryDto);

    ProductCategoryDto getProductCategoryById(Long productCategoryId);

    List<ProductCategoryDto> getAllProductCategory();
}
