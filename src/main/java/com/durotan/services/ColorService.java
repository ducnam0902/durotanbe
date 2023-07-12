package com.durotan.services;

import com.durotan.daodto.ColorDto;

import java.util.List;

public interface ColorService {
    ColorDto createColor(ColorDto colorDto);

    ColorDto getColorById(Long colorId);

    List<ColorDto> getAllColor();

    ColorDto updateColor(Long colorId, ColorDto colorDto);

    void deleteColor(long colorId);
}
