package com.durotan.services.impl;

import com.durotan.daodto.ColorDto;
import com.durotan.entity.Color;
import com.durotan.exception.ResourceNotFoundException;
import com.durotan.mapper.ColorMapper;
import com.durotan.repository.ColorRepository;
import com.durotan.services.ColorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ColorServicesImpl implements ColorService {
    private ColorRepository colorRepository;

    @Override
    public ColorDto createColor(ColorDto colorDto) {
        Color newColor = ColorMapper.mapToColor(colorDto);
        Color savedColor = colorRepository.save(newColor);
        return ColorMapper.mapToColorDto(savedColor);
    }

    @Override
    public ColorDto getColorById(Long colorId) {
        Color color = colorRepository.findById(colorId).orElseThrow(() -> new ResourceNotFoundException("Color is not exists with a given id" + colorId));
        System.out.println(color.toString());
        return ColorMapper.mapToColorDto(color);
    }

    @Override
    public List<ColorDto> getAllColor() {
        List<Color> colors = colorRepository.findAll();
        return colors.stream().map(color -> ColorMapper.mapToColorDto(color))
                .collect(Collectors.toList());
    }

    @Override
    public ColorDto updateColor(Long colorId, ColorDto colorDto) {
        Color color = colorRepository.findById(colorId).orElseThrow(() -> new ResourceNotFoundException("Color is not exists with a given id" + colorId));
        color.setColorName(colorDto.getColorName());

        Color savedColor = colorRepository.save(color);
        return ColorMapper.mapToColorDto(savedColor);
    }

    @Override
    public void deleteColor(long colorId) {
        colorRepository.findById(colorId).orElseThrow(() -> new ResourceNotFoundException("Color is not exists with a given id" + colorId));
        colorRepository.deleteById(colorId);
    }
}
