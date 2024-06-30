package com.example.demo.dto;

import lombok.Data;

@Data
public class AddressDto {
    private Long id;
    private String street;
    private String city;
    private String zipCode;
    private Long studentId;
    // Getters and Setters
}
