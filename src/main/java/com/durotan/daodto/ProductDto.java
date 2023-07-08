package com.durotan.daodto;

import com.durotan.entity.Color;
import com.durotan.entity.Product;
import com.durotan.entity.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
@Data
public class ProductDto {
    Long id;
    String sku;
    Long quanityInStock;
    BigDecimal price;
    List<String> images;
    String size;
    String productName;
    String description;
    String color;

}
