package com.example.demo.dto;

import lombok.Data;

import java.util.List;
import java.util.Set;
@Data
public class StudentDto {
    private Long id;
    private String name;
    private Set<Long> courseIds;
    private Long departmentId;
    private Long addressId;

    // Getters and Setters
}
