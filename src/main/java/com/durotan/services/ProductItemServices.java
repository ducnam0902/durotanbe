package com.durotan.services;


import com.durotan.daodto.FilterCriteriaDto;
import com.durotan.daodto.ProductItemDto;
import com.durotan.daodto.ProductResultDto;

import java.util.List;


public interface ProductItemServices {

    ProductItemDto createProductItem(ProductItemDto productItemDto);

    ProductItemDto getProductItemById(Long productItemId);
    List<ProductItemDto> getAllProductItem();

    List<ProductResultDto> getFeaturedProduct();

    List<ProductResultDto> getFilterProduct(FilterCriteriaDto conditions);
}
