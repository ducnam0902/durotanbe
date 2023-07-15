package com.durotan.mapper;

import com.durotan.daodto.ProductDto;
import com.durotan.entity.Product;
import com.durotan.entity.ProductCategory;

public class ProductMapper {

    public static ProductDto mapToProductDto(Product product){
        ProductDto productDto = new ProductDto();
       productDto.setId(product.getId());
       productDto.setName(product.getName());
       productDto.setDescription(product.getDescription());
       productDto.setCategoryId(product.getCategory().getId());
       return productDto;
    };

    public static Product mapToProduct(ProductDto productDto, ProductCategory productCategory){
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setCategory(productCategory);
        return product;
    }


}
