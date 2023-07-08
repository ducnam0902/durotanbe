package com.durotan.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table( name = "user_review")
public class UserReview {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;
    private Number ratingValue;
    private String comments;

    @ManyToOne
    @JoinColumn( name = "user", referencedColumnName = "id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn( name ="order_line", referencedColumnName = "id")
    @JsonIgnore
    private OrderLine orderLine;
}
