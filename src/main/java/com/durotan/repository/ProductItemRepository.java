package com.durotan.repository;


import com.durotan.daodto.ProductResultDto;
import com.durotan.entity.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {

    List<ProductItem> findByProductId(Long id);
    @Query(value = "SELECT DISTINCT p.colors.id FROM ProductItem p WHERE p.product.id = ?1 ")
    List<Long> findAllColorByProductId(Long id);
    @Query(value = "SELECT p FROM ProductItem p WHERE p.product.id = ?1 AND p.colors.id = ?2")
    List<ProductItem> findAllByProductIdAndColorId(Long productId, Long colorId);
}
