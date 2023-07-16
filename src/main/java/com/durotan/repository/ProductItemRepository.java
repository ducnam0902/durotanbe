package com.durotan.repository;


import com.durotan.daodto.ProductResultDto;
import com.durotan.entity.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {

    List<ProductItem> findByProductId(Long id);
}
