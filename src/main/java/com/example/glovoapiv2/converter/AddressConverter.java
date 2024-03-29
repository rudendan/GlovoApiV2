package com.example.glovoapiv2.converter;

import com.example.glovoapiv2.dto.AddressDto;
import com.example.glovoapiv2.entity.AddressEntity;

public class AddressConverter {

    public static AddressEntity toEntity(AddressDto address) {
        return AddressEntity.builder()
                .street(address.getStreet())
                .house(address.getHouse())
                .apartment(address.getApartment())
                .build();
    }

    public static AddressDto toDto(AddressEntity address) {
        return AddressDto.builder()
                .street(address.getStreet())
                .house(address.getHouse())
                .apartment(address.getApartment())
                .build();
    }
}
