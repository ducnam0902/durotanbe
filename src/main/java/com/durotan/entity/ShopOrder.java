package com.durotan.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
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
    @JsonIgnore
    private SiteUser siteUser;

    @ManyToOne
    @JoinColumn( name = "payment_method_id", referencedColumnName = "id")
    @JsonIgnore
    private UserPaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn( name = "shipping_address", referencedColumnName = "id")
    @JsonIgnore
    private Address address ;

    @ManyToOne
    @JoinColumn( name = "shipping_method", referencedColumnName = "id")
    @JsonIgnore
    private ShippingMethod shippingMethod;

    @ManyToOne
    @JoinColumn( name = "order_status", referencedColumnName = "id")
    @JsonIgnore
    private OrderStatus orderStatus;

    @OneToMany(fetch =  FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "shopOrder")
    private List<OrderLine> orderLines = new ArrayList<>();

}
