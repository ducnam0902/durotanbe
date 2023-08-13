package com.durotan.repository;

import com.durotan.entity.Product;
import com.durotan.entity.ProductCategory;
import com.durotan.entity.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findTop4ByOrderByIdDesc();
    List<Product> findByCategory(ProductCategory category);
}
