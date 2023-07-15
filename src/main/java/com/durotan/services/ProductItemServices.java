package com.durotan.services;


import com.durotan.daodto.ProductItemDto;

import java.util.List;


public interface ProductItemServices {

    ProductItemDto createProductItem(ProductItemDto productItemDto);

    ProductItemDto getProductItemById(Long productItemId);
    List<ProductItemDto> getAllProductItem();
}
