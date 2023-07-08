package com.durotan.entity;

import com.durotan.repository.ColorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ColorTest {

    @Autowired
    private ColorRepository repository;

    @Test
    void saveColor(){
        Color newColor = new Color();
        newColor.setColorName("red");

        Color newColor2 = new Color();
        newColor2.setColorName("blue");

        Color newColor3 = new Color();
        newColor3.setColorName("green");

        List<Color> colorsList = new ArrayList<>();
        colorsList.add(newColor);
        colorsList.add(newColor2);
        colorsList.add(newColor3);

        repository.saveAll(colorsList);


    }
}