package com.durotan.entity;

import javax.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table( name = "order_status")
public class OrderStatus {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;
    private String status;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy ="orderStatus")
    private List<ShopOrder> shopOrders = new ArrayList<>();

}
