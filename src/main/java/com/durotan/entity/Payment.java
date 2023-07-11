package com.durotan.entity;

import javax.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table( name = "payment")
public class Payment {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;

    private String paymentType;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy ="payment")
    private List<UserPaymentMethod> paymentMethod = new ArrayList<>();
}
