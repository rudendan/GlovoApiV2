package com.example.glovoapiv2.service;

import com.example.glovoapiv2.convertor.AddressConvertor;
import com.example.glovoapiv2.dto.AddressDto;
import com.example.glovoapiv2.entity.AddressEntity;
import com.example.glovoapiv2.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressEntity save(AddressDto address) {
        return addressRepository.save(AddressConvertor.toEntity(address));
    }
}
