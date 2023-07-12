package com.durotan.controller;

import com.durotan.daodto.ColorDto;
import com.durotan.services.ColorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value ="/api/v1/color", produces = "application/json")
public class ColorController {
    private ColorService colorService;

    @PostMapping
    public ResponseEntity<ColorDto> createColor(@RequestBody ColorDto colorDto){
        ColorDto color = colorService.createColor(colorDto);
        return new ResponseEntity<>(color, HttpStatus.CREATED);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ColorDto> getColorById(@PathVariable("id") Long colorId){
        ColorDto colorDto = colorService.getColorById(colorId);
        return ResponseEntity.ok(colorDto);
    }

    @GetMapping
    public ResponseEntity<List<ColorDto>> getAllColors(){
        List<ColorDto> colors = colorService.getAllColor();
        return ResponseEntity.ok(colors);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<ColorDto> updateColor(@PathVariable("id") Long colorId, @RequestBody ColorDto updatedColor){
        ColorDto colorDto = colorService.updateColor(colorId, updatedColor);
        return ResponseEntity.ok(colorDto);
    }

    @DeleteMapping(value="{id}")
    public ResponseEntity<String> deleteColor(@PathVariable("id") Long colorId){
        colorService.deleteColor(colorId);
        return ResponseEntity.ok("Color deleted successfully.");
    }

}
