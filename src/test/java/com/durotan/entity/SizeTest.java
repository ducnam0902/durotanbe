package com.durotan.entity;

import com.durotan.repository.ColorRepository;
import com.durotan.repository.SizeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SizeTest {
    @Autowired
    private SizeRepository repository;

    @Test
    void saveSize(){
        Size newSize = new Size();
        newSize.setSizeName("XS");

        Size newSize2 = new Size();
        newSize2.setSizeName("S");

        Size newSize3 = new Size();
        newSize3.setSizeName("M");

        Size newSize4 = new Size();
        newSize4.setSizeName("XL");

        repository.save(newSize);
        repository.save(newSize2);
        repository.save(newSize3);
        repository.save(newSize4);


    }
}