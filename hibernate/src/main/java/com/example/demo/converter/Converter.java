//package com.example.demo.converter;
//
//import com.example.demo.dto.*;
//import com.example.demo.entity.*;
//import com.example.demo.mapper.*;
//import org.springframework.stereotype.Component;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//public class Converter {
//    private final AddressMapper addressMapper;
//    private final CourseMapper courseMapper;
//    private final DepartmentMapper departmentMapper;
//    private final StudentMapper studentMapper;
//
//    public Converter(AddressMapper addressMapper, CourseMapper courseMapper, DepartmentMapper departmentMapper, StudentMapper studentMapper) {
//        this.addressMapper = addressMapper;
//        this.courseMapper = courseMapper;
//        this.departmentMapper = departmentMapper;
//        this.studentMapper = studentMapper;
//    }
//
//    public AddressDto convertToDTO(Address address) {
//        return addressMapper.toDTO(address);
//    }
//
//    public Address convertToEntity(AddressDto addressDTO) {
//        return addressMapper.toEntity(addressDTO);
//    }
//
//    public CourseDto convertToDTO(Course course) {
//        return courseMapper.toDTO(course);
//    }
//
//    public Course convertToEntity(CourseDto courseDTO) {
//        return courseMapper.toEntity(courseDTO);
//    }
//
//
//    public DepartmentDto convertToDTO(Department department) {
//        return departmentMapper.toDTO(department);
//    }
//    public Department convertToEntity(DepartmentDto departmentDTO) {
//        return departmentMapper.toEntity(departmentDTO);
//    }
//
//
//    public StudentDto convertToDTO(Student student) {
//        return studentMapper.toDTO(student);
//    }
//
//    public Student convertToEntity(StudentDto studentDTO) {
//        return studentMapper.toEntity(studentDTO);
//    }
//
//    public List<CourseDto> convertCoursesToDTO(List<Course> courses) {
//        return courses.stream().map(courseMapper::toDTO).collect(Collectors.toList());
//    }
//
//    public List<StudentDto> convertStudentsToDTO(List<Student> students) {
//        return students.stream().map(studentMapper::toDTO).collect(Collectors.toList());
//    }
//}
