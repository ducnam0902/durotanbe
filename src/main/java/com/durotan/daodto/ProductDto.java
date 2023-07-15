package com.durotan.daodto;


import lombok.Data;

@Data
public class ProductDto {
    Long id;
    String name;
    String description;
    ProductCategoryDto category;

}
