package com.durotan.daodto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductResultDto {
    String name;
    BigDecimal price;
    List<QuanityGroupDto> quanity;

}
