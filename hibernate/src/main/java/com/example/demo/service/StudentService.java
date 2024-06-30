package com.example.demo.service;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.converter.StudentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentConverter studentConverter;
    @Autowired
    private AddressRepository addressRepository;

    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll().stream().map(studentConverter::entityToDto).collect(Collectors.toList());
    }

    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        return studentConverter.entityToDto(student);
    }

    public StudentDto createStudent(StudentDto studentDto) {
        Student student = studentConverter.dtoToEntity(studentDto);
        student = studentRepository.save(student);
        return studentConverter.entityToDto(student);
    }

    public StudentDto updateStudent(Long id, StudentDto studentDto) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        student.setName(studentDto.getName());
        student.setCourses(studentDto.getCourseIds().stream().map(courseId -> courseRepository.findById(courseId).orElse(null)).collect(Collectors.toSet()));
        student.setDepartment(departmentRepository.findById(studentDto.getDepartmentId()).orElse(null));
        student.setAddress(addressRepository.findById(studentDto.getAddressId()).orElse(null));
        student = studentRepository.save(student);
        return studentConverter.entityToDto(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
