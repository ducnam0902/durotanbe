package com.durotan.services.impl;

import com.durotan.daodto.SizeDto;
import com.durotan.entity.Size;
import com.durotan.exception.ResourceNotFoundException;
import com.durotan.mapper.SizeMapper;
import com.durotan.repository.SizeRepository;
import com.durotan.services.SizeServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SizeServicesImpl implements SizeServices {

    private SizeRepository sizeRepository;

    @Override
    public SizeDto createSize(SizeDto sizeDto) {
        Size newSize = SizeMapper.mapToSize(sizeDto);
        Size savedSize = sizeRepository.save(newSize);
        return SizeMapper.mapToSizeDto(savedSize);
    }

    @Override
    public SizeDto getSizeById(Long sizeId) {
        Size size = sizeRepository.findById(sizeId).orElseThrow(() -> new ResourceNotFoundException("Size is not exists with a given id "+ sizeId));
        return SizeMapper.mapToSizeDto(size);
    }

    @Override
    public List<SizeDto> getAllSize() {
        List<Size> sizes = sizeRepository.findAll();
        return sizes.stream().map(size -> SizeMapper.mapToSizeDto(size))
                .collect(Collectors.toList());
    }
}
