package com.durotan.entity;

import com.durotan.repository.ColorRepository;
import com.durotan.repository.ProductItemRepository;
import com.durotan.repository.ProductRepository;
import com.durotan.repository.SizeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductItemTest {
    @Autowired
    private ProductItemRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private SizeRepository sizeRepository;


    @Test
    void saveProductItem(){
        Product product = productRepository.findById(1L).get();
        Size size = sizeRepository.findById(5L).get();
        Color color = colorRepository.findById(5L).get();
        ProductItem product1 = new ProductItem();
        product1.setProduct(product);
        product1.setPrice(new BigDecimal(24.9));
        product1.setQuanityInStock(200L);
        product1.setSku("457161");
        product1.setColors(color);
        product1.setSize(size);
        product1.setImages(List.of("https://image.uniqlo.com/UQ/ST3/us/imagesgoods/457161/item/usgoods_61_457161.jpg?width=600"));
        repository.save(product1);
    }


}