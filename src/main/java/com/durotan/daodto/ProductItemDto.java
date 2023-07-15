package com.durotan.daodto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductItemDto {
    long id;
    String sku;
    long quanityInStock;
    BigDecimal price;
    String images1;
    String images2;
    long size;
    long color;
    long product;


}
