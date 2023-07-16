package com.durotan.daodto;

import lombok.Data;

import java.util.List;
@Data
public class QuanityGroupDto {
    String color;
    List<String> images;
    List<SizeGroupDto> size;
}
