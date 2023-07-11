package com.durotan.entity;

import javax.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table( name = "country")
public class Country {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;
    private String countryName;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy ="country")
    private List<Address> addresses = new ArrayList<>();
}
