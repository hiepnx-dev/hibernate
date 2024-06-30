package com.example.demo.service;

import com.example.demo.converter.DepartmentConverter;
import com.example.demo.dto.DepartmentDto;
import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private DepartmentConverter departmentConverter;

    public List<DepartmentDto> getAllDepartments() {
        return departmentRepository.findAll().stream().map(departmentConverter::entityToDto).collect(Collectors.toList());
    }

    public DepartmentDto getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
        return departmentConverter.entityToDto(department);
    }

    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = departmentConverter.dtoToEntity(departmentDto);
        department = departmentRepository.save(department);
        return departmentConverter.entityToDto(department);
    }

    public DepartmentDto updateDepartment(Long id, DepartmentDto departmentDto) {
        Department department = departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
        department.setName(departmentDto.getName());
        department.setStudents(departmentDto.getStudentIds().stream().map(studentId -> studentRepository.findById(studentId).orElse(null)).collect(Collectors.toSet()));
        department = departmentRepository.save(department);
        return departmentConverter.entityToDto(department);
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
