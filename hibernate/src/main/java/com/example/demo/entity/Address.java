package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String city;
    private String zipCode;

    @OneToOne(mappedBy = "address")
    private Student student;

    // Getters and Setters
}
