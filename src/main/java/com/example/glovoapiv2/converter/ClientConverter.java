package com.example.glovoapiv2.converter;

import com.example.glovoapiv2.dto.ClientDto;
import com.example.glovoapiv2.entity.ClientEntity;

public class ClientConverter {

    public static ClientEntity toEntity(ClientDto client) {
        return ClientEntity.builder()
                .name(client.getName())
                .surname(client.getSurname())
                .address(AddressConverter.toEntity(client.getAddress()))
                .phoneNumber(client.getPhoneNumber())
                .build();
    }

    public static ClientDto toDto(ClientEntity client) {
        return ClientDto.builder()
                .name(client.getName())
                .surname(client.getSurname())
                .address(AddressConverter.toDto(client.getAddress()))
                .phoneNumber(client.getPhoneNumber())
                .build();
    }
}
