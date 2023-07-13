package com.durotan.controller;

import com.durotan.daodto.SizeDto;
import com.durotan.services.SizeServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@CrossOrigin(origins = "*")
@RestController
@RequestMapping( value ="/api/v1/size", produces = "application/json")
public class SizeController {
    private SizeServices sizeServices;

    @PostMapping
    public ResponseEntity<SizeDto> createSize(@RequestBody SizeDto sizeDto){
        SizeDto size = sizeServices.createSize(sizeDto);
        return new ResponseEntity<>(size, HttpStatus.CREATED);
    }

    @GetMapping( value ="{id}")
    public ResponseEntity<SizeDto> getColorById(@PathVariable("id") long sizeId){
        SizeDto sizeDto = sizeServices.getSizeById(sizeId);
        return ResponseEntity.ok(sizeDto);
    }

    @GetMapping
    public ResponseEntity<List<SizeDto>> getAllSizes(){
        List<SizeDto> sizes = sizeServices.getAllSize();
        return ResponseEntity.ok(sizes);
    }
}
