package com.durotan.mapper;

import com.durotan.daodto.ProductCategoryDto;
import com.durotan.entity.ProductCategory;

public class ProductCategoryMapper {

    public static ProductCategoryDto mapToProductCategoryDto(ProductCategory productCategory){
        ProductCategoryDto productCategoryDto = new ProductCategoryDto();
        productCategoryDto.setId(productCategoryDto.getId());
        productCategoryDto.setCategoryName(productCategoryDto.getCategoryName());
        return productCategoryDto;
    };

    public static ProductCategory mapToProductCategory(ProductCategoryDto productCategoryDto){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(productCategoryDto.getId());
        productCategory.setCategoryName(productCategoryDto.getCategoryName());
        return productCategory;
    }
}