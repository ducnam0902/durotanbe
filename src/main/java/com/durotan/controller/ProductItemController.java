package com.durotan.controller;

import com.durotan.daodto.ProductDto;
import com.durotan.services.ProductItemServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/product-item")
public class ProductItemController {

    private ProductItemServices productItemServices;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return ResponseEntity.ok(productItemServices.getAllProductItem());
    }
}
