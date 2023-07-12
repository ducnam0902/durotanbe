package com.durotan.mapper;

import com.durotan.daodto.ColorDto;
import com.durotan.entity.Color;

public class ColorMapper {
    public static ColorDto mapToColorDto(Color color){
        ColorDto colorDto = new ColorDto();
        colorDto.setId(color.getId());
        colorDto.setColorName(color.getColorName());
        return colorDto;
    }

    public static Color mapToColor(ColorDto colorDto){
        Color color = new Color();
        color.setId(colorDto.getId());
        color.setColorName(colorDto.getColorName());
        return color;
    }
}
