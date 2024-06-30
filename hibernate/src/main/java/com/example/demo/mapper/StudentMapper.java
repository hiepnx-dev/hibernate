package com.example.demo.mapper;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    @Mapping(source = "courses", target = "courseIds")
    @Mapping(source = "department.id", target = "departmentId")
    @Mapping(source = "address.id", target = "addressId")
    StudentDto toDto(Student student);

    @Mapping(source = "courseIds", target = "courses")
    @Mapping(source = "departmentId", target = "department")
    @Mapping(source = "addressId", target = "address")
    Student toEntity(StudentDto studentDto);
}
