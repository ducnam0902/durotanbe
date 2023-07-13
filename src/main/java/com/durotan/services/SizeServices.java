package com.durotan.services;

import com.durotan.daodto.SizeDto;

import java.util.List;

public interface SizeServices {
    SizeDto createSize(SizeDto sizeDto);

    SizeDto getSizeById(Long sizeId);

    List<SizeDto> getAllSize();

}
