package com.durotan.entity;

import javax.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table( name = "shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch =  FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "shoppingCart")
    private List<ShoppingCartItem> cartItem = new ArrayList<>();


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "shoppingCart")
    private SiteUser siteUser;
}
