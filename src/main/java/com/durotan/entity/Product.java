package com.durotan.entity;

import javax.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table( name ="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    @Column( length = 100000 )
    private String description;
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name ="category_id", referencedColumnName = "id")
    private ProductCategory category;

    @OneToMany(fetch =  FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product")
    private List<ProductItem> productItemList = new ArrayList<>();


}
