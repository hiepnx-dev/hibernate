package com.example.demo.service;

import com.example.demo.dto.AddressDto;
import com.example.demo.entity.Address;
import com.example.demo.repository.AddressRepository;
import com.example.demo.converter.AddressConverter;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private AddressConverter addressConverter;

    public List<AddressDto> getAllAddresses() {
        return addressRepository.findAll().stream().map(addressConverter::entityToDto).collect(Collectors.toList());
    }

    public AddressDto getAddressById(Long id) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new RuntimeException("Address not found"));
        return addressConverter.entityToDto(address);
    }

    public AddressDto createAddress(AddressDto addressDto) {
        Address address = addressConverter.dtoToEntity(addressDto);
        address = addressRepository.save(address);
        return addressConverter.entityToDto(address);
    }

    public AddressDto updateAddress(Long id, AddressDto addressDto) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new RuntimeException("Address not found"));
        address.setStreet(addressDto.getStreet());
        address.setCity(addressDto.getCity());
        address.setZipCode(addressDto.getZipCode());
        address.setStudent(studentRepository.findById(addressDto.getStudentId()).orElse(null));
        address = addressRepository.save(address);
        return addressConverter.entityToDto(address);
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
