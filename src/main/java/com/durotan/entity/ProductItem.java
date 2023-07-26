package com.durotan.entity;

import javax.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table( name ="product_item")
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String sku;
    private long quanityInStock;
    private String image1;
    private String image2;

    @ManyToOne
    @JoinColumn( name ="size_id", referencedColumnName = "id")
    private Size size;

    @ManyToOne
    @JoinColumn( name ="color_id", referencedColumnName = "id")
    private Color colors;

    @OneToMany(fetch =  FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "productItem")
    private List<ShoppingCartItem> cartItem = new ArrayList<>();

    @OneToMany(fetch =  FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "productItems")
    private List<OrderLine> orderLine = new ArrayList<>();

    @ManyToOne
    @JoinColumn( name ="product_id", referencedColumnName = "id")
    private Product product;

}
