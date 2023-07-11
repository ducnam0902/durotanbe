package com.durotan.entity;

import javax.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table( name = "color")
public class Color {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;

    private String colorName;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy ="colors")
    private List<ProductItem> productItem = new ArrayList<>();
}
