package com.durotan.services;

import com.durotan.daodto.ProductDto;

import java.util.List;

public interface ProductServices {
    ProductDto createProduct(ProductDto productDto);

    ProductDto getProductById(Long productId);

    List<ProductDto> getAllProduct();
}
