package com.example.demo.converter;

import com.example.demo.dto.CourseDto;
import com.example.demo.entity.Course;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CourseConverter {
    @Autowired
    private StudentRepository studentRepository;

    public CourseDto entityToDto(Course course) {
        CourseDto dto = new CourseDto();
        dto.setId(course.getId());
        dto.setName(course.getName());
        dto.setStudentIds(course.getStudents().stream().map(student -> student.getId()).collect(Collectors.toSet()));
        return dto;
    }

    public Course dtoToEntity(CourseDto dto) {
        Course course = new Course();
        course.setId(dto.getId());
        course.setName(dto.getName());
        course.setStudents(dto.getStudentIds().stream().map(studentId -> studentRepository.findById(studentId).orElse(null)).collect(Collectors.toSet()));
        return course;
    }
}
