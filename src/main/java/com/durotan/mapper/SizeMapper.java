package com.durotan.mapper;

import com.durotan.daodto.SizeDto;
import com.durotan.entity.Size;

public class SizeMapper {

    public static SizeDto mapToSizeDto(Size size ){
        SizeDto sizeDto = new SizeDto();
        sizeDto.setId(size.getId());
        sizeDto.setSizeName(size.getSizeName());

        return sizeDto;
    }

    public static Size mapToSize(SizeDto sizeDto){
        Size size = new Size();
        size.setId(sizeDto.getId());
        size.setSizeName(sizeDto.getSizeName());

        return size;
    }
}
