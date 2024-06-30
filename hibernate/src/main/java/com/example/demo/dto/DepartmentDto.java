package com.example.demo.dto;

import lombok.Data;

import java.util.Set;

@Data
public class DepartmentDto {
    private Long id;
    private String name;
    private Set<Long> studentIds;

    // Getters and Setters
}
