package com.durotan.services;

import com.durotan.daodto.ProductDto;
import com.durotan.entity.ProductItem;

import java.util.List;

public interface ProductItemServices {
    List<ProductDto> getAllProductItem();
}
