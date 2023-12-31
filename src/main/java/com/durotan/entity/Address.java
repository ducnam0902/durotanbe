package com.durotan.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table( name = "address")
public class Address {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;
    private String unitNumber;
    private String streetNumber;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String region;
    private String postalCode;

    @ManyToOne
    @JoinColumn(name ="country_id", referencedColumnName = "id")
    private Country country;

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, mappedBy = "address"    )
    private Set<SiteUser> siteUsers = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy ="address")
    private List<ShopOrder> shopOrders = new ArrayList<>();

}
