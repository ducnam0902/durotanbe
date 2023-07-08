package com.durotan.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table( name = "order_line")
public class OrderLine {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private long quanity;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn( name = "shop_order", referencedColumnName = "id")
    private ShopOrder shopOrder;

    @ManyToOne
    @JoinColumn( name = "product_item", referencedColumnName = "id")
    private ProductItem productItems;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy ="orderLine")
    private List<UserReview> userReviews = new ArrayList<>();

}
