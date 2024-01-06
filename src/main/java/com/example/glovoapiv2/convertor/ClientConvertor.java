package com.example.glovoapiv2.convertor;

import com.example.glovoapiv2.dto.ClientDto;
import com.example.glovoapiv2.entity.ClientEntity;

public class ClientConvertor {

    public static ClientEntity toEntity(ClientDto client) {
        return ClientEntity.builder()
                .name(client.getName())
                .surname(client.getSurname())
                .address(AddressConvertor.toEntity(client.getAddress()))
                .phoneNumber(client.getPhoneNumber())
                .build();
    }

    public static ClientDto toDto(ClientEntity client) {
        return ClientDto.builder()
                .name(client.getName())
                .surname(client.getSurname())
                .address(AddressConvertor.toDto(client.getAddress()))
                .phoneNumber(client.getPhoneNumber())
                .build();
    }
}
