package com.durotan.entity;

import javax.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table( name = "shipping_method")
public class ShippingMethod {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy ="shippingMethod")
    private List<ShopOrder> shopOrders = new ArrayList<>();
}
