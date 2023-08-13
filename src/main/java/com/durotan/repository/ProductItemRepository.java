package com.durotan.repository;


import com.durotan.entity.Color;
import com.durotan.entity.Product;
import com.durotan.entity.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {

    List<ProductItem> findAllByProduct(Product product);

    List<ProductItem> findByColorsIn(List<Color> colorName);

    List<ProductItem> findByProductInAndColorsIn(List<Product> product, List<Color> color);

}
