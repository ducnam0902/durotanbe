package com.durotan.mapper;

import com.durotan.daodto.ProductCategoryDto;
import com.durotan.entity.ProductCategory;

public class ProductCategoryMapper {

    public static ProductCategoryDto mapToProductCategoryDto(ProductCategory productCategory){
        ProductCategoryDto productCategoryDto = new ProductCategoryDto();
        productCategoryDto.setId(productCategory.getId());
        productCategoryDto.setCategoryName(productCategory.getCategoryName());
        return productCategoryDto;
    };

    public static ProductCategory mapToProductCategory(ProductCategoryDto productCategoryDto){
        ProductCategory productCategory = new ProductCategory();
        if(productCategoryDto.getId() != null){
            productCategory.setId(productCategoryDto.getId());
        }

        productCategory.setCategoryName(productCategoryDto.getCategoryName());
        return productCategory;
    }
}
