package com.durotan.controller;

import com.durotan.daodto.ProductCategoryDto;
import com.durotan.services.ProductCategoryServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@CrossOrigin(origins = "*")
@RestController
@RequestMapping( value = "/api/v1/productcategory", produces = "application/json")
public class ProductCategoryController {
    private ProductCategoryServices productCategoryServices;

    @PostMapping
    public ResponseEntity<ProductCategoryDto> createProductCateggory(@RequestBody ProductCategoryDto productCategoryDto){
        ProductCategoryDto productCategory = productCategoryServices.createProductCategory(productCategoryDto);
        return new ResponseEntity<>(productCategory, HttpStatus.CREATED);
    }

    @GetMapping( value = "{id}")
    public ResponseEntity<ProductCategoryDto> getProductCategoryById(@PathVariable("id") long productCategoryId){
        ProductCategoryDto categoryDto = productCategoryServices.getProductCategoryById(productCategoryId);
        return ResponseEntity.ok(categoryDto);
    }

    @GetMapping
    public ResponseEntity<List<ProductCategoryDto>> getAllProductCategory(){
        List<ProductCategoryDto> categories = productCategoryServices.getAllProductCategory();
        return ResponseEntity.ok(categories);
    }
}
