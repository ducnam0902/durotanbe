package com.durotan.daodto;

import lombok.Data;

import java.util.List;

@Data
public class FilterCriteriaDto {
    List<String> colorName;
    String categoryName;
}
