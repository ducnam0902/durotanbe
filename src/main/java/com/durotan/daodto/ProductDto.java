package com.durotan.daodto;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {
    Long id;
    String name;
    BigDecimal price;
    String description;
    Long categoryId;

}
