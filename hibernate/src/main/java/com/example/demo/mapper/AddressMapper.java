package com.example.demo.mapper;

import com.example.demo.dto.AddressDto;
import com.example.demo.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    @Mapping(source = "student.id", target = "studentId")
    AddressDto toDto(Address address);

    @Mapping(source = "studentId", target = "student")
    Address toEntity(AddressDto addressDto);
}
