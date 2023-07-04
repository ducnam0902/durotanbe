package com.durotan.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table( name = "color")
public class Color {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;

    private String colorName;
}
