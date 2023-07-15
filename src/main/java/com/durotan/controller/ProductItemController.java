package com.durotan.controller;

import com.durotan.daodto.ProductDto;
import com.durotan.daodto.ProductItemDto;
import com.durotan.services.ProductItemServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/product-item")
public class ProductItemController {

    private ProductItemServices productItemServices;

    @PostMapping
    public ResponseEntity<ProductItemDto> createProductItem(@RequestBody ProductItemDto productItemDto){
        ProductItemDto productItem = productItemServices.createProductItem(productItemDto);
        return new ResponseEntity<>(productItem, HttpStatus.CREATED);
    }

    @GetMapping( value = "{id}")
    public ResponseEntity<ProductItemDto> getProductItemById(@PathVariable("id") Long productItemId){
        ProductItemDto productItem = productItemServices.getProductItemById(productItemId);
        return ResponseEntity.ok(productItem);
    }

    @GetMapping
    public ResponseEntity<List<ProductItemDto>> getAllProducts(){
        return ResponseEntity.ok(productItemServices.getAllProductItem());
    }
}
