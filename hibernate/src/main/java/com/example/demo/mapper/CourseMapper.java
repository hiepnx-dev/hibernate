package com.example.demo.mapper;

import com.example.demo.dto.CourseDto;
import com.example.demo.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseDto toDTO(Course course);
    Course toEntity(CourseDto courseDTO);
}
