package com.example.demo.converter;

import com.example.demo.dto.DepartmentDto;
import com.example.demo.entity.Department;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class DepartmentConverter {
    @Autowired
    private StudentRepository studentRepository;

    public DepartmentDto entityToDto(Department department) {
        DepartmentDto dto = new DepartmentDto();
        dto.setId(department.getId());
        dto.setName(department.getName());
        dto.setStudentIds(department.getStudents().stream().map(student -> student.getId()).collect(Collectors.toSet()));
        return dto;
    }

    public Department dtoToEntity(DepartmentDto dto) {
        Department department = new Department();
        department.setId(dto.getId());
        department.setName(dto.getName());
        department.setStudents(dto.getStudentIds().stream().map(studentId -> studentRepository.findById(studentId).orElse(null)).collect(Collectors.toSet()));
        return department;
    }
}
