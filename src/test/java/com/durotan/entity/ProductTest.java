package com.durotan.entity;

import com.durotan.repository.ProductCategoryRepository;
import com.durotan.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductTest {
    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductCategoryRepository categoryRepository;

    @Test
    void saveProduct(){
        ProductCategory category =  categoryRepository.findByCategoryName("Tshirts");
        Product product1 = new Product();
        product1.setName("Supima® Cotton V-Neck Short-Sleeve T-Shirt");
        product1.setDescription("Overview\n" +
                "- Updated to a more substantial fabric with a premium finish.\n" +
                "- Smooth, pilling-resistant 100% Supima® cotton.\n" +
                "- Basic design styles alone or layered.\n" +
                "- Designed with meticulous attention to detail, down to the collar width and stitching.\n" +
                "- Sleek V-neck.");
        product1.setCategory(category);
        repository.save(product1);



    }

}