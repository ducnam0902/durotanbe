package com.durotan.daodto;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class ProductDto {
    Long id;
    String sku;
    Long quanityInStock;
    BigDecimal price;
    String images;
    String size;
    String productName;
    String description;
    String color;

}
