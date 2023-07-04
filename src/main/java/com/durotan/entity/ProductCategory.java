package com.durotan.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table( name="product_category")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String categoryName;
}
