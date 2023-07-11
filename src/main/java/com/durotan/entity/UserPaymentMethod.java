package com.durotan.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table( name = "user_payment_method")
public class UserPaymentMethod {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;
    private String provider;
    private String accountNumber;
    private Date expiryDate;
    private boolean isDefault;

    @ManyToOne
    @JoinColumn( name = "payment_id", referencedColumnName = "id")
    @JsonIgnore
    private Payment payment;

    @ManyToOne
    @JoinColumn( name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private SiteUser siteUser;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy ="paymentMethod")
    private List<ShopOrder> shopOrders = new ArrayList<>();
}
