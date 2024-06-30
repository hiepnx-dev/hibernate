package com.example.demo.mapper;

import com.example.demo.dto.DepartmentDto;
import com.example.demo.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    @Mapping(source = "students", target = "studentIds")
    DepartmentDto toDto(Department department);

    @Mapping(source = "studentIds", target = "students")
    Department toEntity(DepartmentDto departmentDto);
}
