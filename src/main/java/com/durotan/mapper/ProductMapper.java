package com.durotan.mapper;

import com.durotan.daodto.ProductCategoryDto;
import com.durotan.daodto.ProductDto;
import com.durotan.entity.Product;
import com.durotan.entity.ProductCategory;

public class ProductMapper {

    public static ProductDto mapToProductDto(Product product){
        ProductDto productDto = new ProductDto();
       productDto.setId(product.getId());
       productDto.setName(product.getName());
       productDto.setDescription(product.getDescription());

       ProductCategoryDto categoryDto = new ProductCategoryDto();
       categoryDto.setId(product.getCategory().getId());
       categoryDto.setCategoryName(product.getCategory().getCategoryName());
       productDto.setCategory(categoryDto);
       return productDto;
    };

    public static Product mapToProduct(ProductDto productDto){
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());

        ProductCategory category = new ProductCategory();
        category.setId(productDto.getCategory().getId());
        category.setCategoryName(productDto.getCategory().getCategoryName());
        product.setCategory(category);
        return product;
    }


}
