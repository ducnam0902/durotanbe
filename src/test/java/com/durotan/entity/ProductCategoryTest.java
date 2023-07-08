package com.durotan.entity;

import com.durotan.repository.ProductCategoryRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
//@Transactional
class ProductCategoryTest {

    @Autowired
    private ProductCategoryRepository category;

    @Test
    void getAllProductCategory(){
        List<ProductCategory> listCategory = category.findAll();
       listCategory.forEach(a -> {
           System.out.println(a.toString());
       });
    }

    @Test
    void saveProductCategory(){
        ProductCategory category2 = new ProductCategory();
        category2.setCategoryName("Trousers");

        ProductCategory category3 = new ProductCategory();
        category3.setCategoryName("Jeans");

        ProductCategory category4 = new ProductCategory();
        category4.setCategoryName("Tshirts");

        ProductCategory category5 = new ProductCategory();
        category5.setCategoryName("Shirts");
        category.save(category2);
        category.save(category3);
        category.save(category4);
        category.save(category5);
    }
}