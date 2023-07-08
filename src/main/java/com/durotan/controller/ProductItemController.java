package com.durotan.controller;

import com.durotan.daodto.ProductDto;
import com.durotan.entity.ProductItem;
import com.durotan.services.ProductItemServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productitem")
public class ProductItemController {

    private ProductItemServices productItemServices;

    public ProductItemController(ProductItemServices productItemServices) {
        this.productItemServices = productItemServices;
    }
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return ResponseEntity.ok(productItemServices.getAllProductItem());
    }
}
