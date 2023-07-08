package com.durotan.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table( name = "shop_order")
public class ShopOrder {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private Date orderDate;
    private long orderTotal;

    @ManyToOne
    @JoinColumn( name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn( name = "payment_method_id", referencedColumnName = "id")
    private UserPaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn( name = "shipping_address", referencedColumnName = "id")
    private Address address ;

    @ManyToOne
    @JoinColumn( name = "shipping_method", referencedColumnName = "id")
    private ShippingMethod shippingMethod;

    @ManyToOne
    @JoinColumn( name = "order_status", referencedColumnName = "id")
    private OrderStatus orderStatus;

    @OneToMany(fetch =  FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "shopOrder")
    private List<OrderLine> orderLines = new ArrayList<>();

}
