package com.example.demo.dto;

import lombok.Data;

import java.util.List;
import java.util.Set;
@Data
public class CourseDto {
    private Long id;
    private String name;
    private Set<Long> studentIds;

    // Getters and Setters
}
