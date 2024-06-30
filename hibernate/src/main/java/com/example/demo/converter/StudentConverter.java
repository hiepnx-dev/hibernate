package com.example.demo.converter;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class StudentConverter {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private AddressRepository addressRepository;

    public StudentDto entityToDto(Student student) {
        StudentDto dto = new StudentDto();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setCourseIds(student.getCourses().stream().map(course -> course.getId()).collect(Collectors.toSet()));
        dto.setDepartmentId(student.getDepartment().getId());
        dto.setAddressId(student.getAddress().getId());
        return dto;
    }

    public Student dtoToEntity(StudentDto dto) {
        Student student = new Student();
        student.setId(dto.getId());
        student.setName(dto.getName());
        student.setCourses(dto.getCourseIds().stream().map(courseId -> courseRepository.findById(courseId).orElse(null)).collect(Collectors.toSet()));
        student.setDepartment(departmentRepository.findById(dto.getDepartmentId()).orElse(null));
        student.setAddress(addressRepository.findById(dto.getAddressId()).orElse(null));
        return student;
    }
}
