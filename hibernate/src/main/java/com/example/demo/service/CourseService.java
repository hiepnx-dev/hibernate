package com.example.demo.service;

import com.example.demo.dto.CourseDto;
import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;
import com.example.demo.converter.CourseConverter;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseConverter courseConverter;

    public List<CourseDto> getAllCourses() {
        return courseRepository.findAll().stream().map(courseConverter::entityToDto).collect(Collectors.toList());
    }

    public CourseDto getCourseById(Long id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
        return courseConverter.entityToDto(course);
    }

    public CourseDto createCourse(CourseDto courseDto) {
        Course course = courseConverter.dtoToEntity(courseDto);
        course = courseRepository.save(course);
        return courseConverter.entityToDto(course);
    }

    public CourseDto updateCourse(Long id, CourseDto courseDto) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
        course.setName(courseDto.getName());
        course.setStudents(courseDto.getStudentIds().stream().map(studentId -> studentRepository.findById(studentId).orElse(null)).collect(Collectors.toSet()));
        course = courseRepository.save(course);
        return courseConverter.entityToDto(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
