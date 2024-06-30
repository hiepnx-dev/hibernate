package com.example.demo.converter;

import com.example.demo.dto.AddressDto;
import com.example.demo.entity.Address;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressConverter {
    @Autowired
    private StudentRepository studentRepository;

    public AddressDto entityToDto(Address address) {
        AddressDto dto = new AddressDto();
        dto.setId(address.getId());
        dto.setStreet(address.getStreet());
        dto.setCity(address.getCity());
        dto.setZipCode(address.getZipCode());
        dto.setStudentId(address.getStudent().getId());
        return dto;
    }

    public Address dtoToEntity(AddressDto dto) {
        Address address = new Address();
        address.setId(dto.getId());
        address.setStreet(dto.getStreet());
        address.setCity(dto.getCity());
        address.setZipCode(dto.getZipCode());
        address.setStudent(studentRepository.findById(dto.getStudentId()).orElse(null));
        return address;
    }
}
