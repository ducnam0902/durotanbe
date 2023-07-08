package com.durotan.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table( name = "shopping_cart_item")
public class ShoppingCartItem {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private Long quanity;

    @ManyToOne
    @JoinColumn( name = "shopping_cart_id", referencedColumnName = "id")
    private ShoppingCart shoppingCart;

    @ManyToOne
    @JoinColumn( name = "product_item_id", referencedColumnName = "id")
    private ProductItem productItem;

}