package com.durotan.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table( name = "size")
public class Size {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private String sizeName;
}
