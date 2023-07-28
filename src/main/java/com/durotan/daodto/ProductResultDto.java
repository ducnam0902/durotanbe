package com.durotan.daodto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductResultDto {
    String name;
    String category;
    BigDecimal price;
    List<ColorGroupDto> quanity;

}
