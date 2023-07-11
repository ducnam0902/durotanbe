package com.durotan.entity;

import javax.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table( name = "site_user")
public class SiteUser {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;
    private String emailAddress;
    private String phoneNumber;
    private String password;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy ="siteUser")
    private List<UserPaymentMethod> paymentMethod = new ArrayList<>();

    @ManyToMany( cascade = CascadeType.ALL)
    @JoinTable( name ="user_address",
            joinColumns = @JoinColumn(name ="user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "address_id", referencedColumnName = "id")
    )
    private Set<Address> address = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="shopping_cart_id", referencedColumnName = "id")
    private ShoppingCart shoppingCart;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy ="siteUser")
    private List<ShopOrder> shopOrders= new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy ="siteUser")
    private List<UserReview> userReviews = new ArrayList<>();

}
