package com.durotan.daodto;

import lombok.Data;

import java.util.List;
@Data
public class ColorGroupDto {
    String colorName;
    List<String> images;
    List<SizeGroupDto> size;
}
