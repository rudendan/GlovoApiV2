package com.example.glovoapiv2.service;

import com.example.glovoapiv2.convertor.ClientConvertor;
import com.example.glovoapiv2.dto.ClientDto;
import com.example.glovoapiv2.entity.AddressEntity;
import com.example.glovoapiv2.entity.ClientEntity;
import com.example.glovoapiv2.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private ClientRepository clientRepository;
    private AddressService addressService;

    @Autowired
    public ClientService(ClientRepository clientRepository, AddressService addressService) {
        this.clientRepository = clientRepository;
        this.addressService = addressService;
    }

    public ClientEntity save(ClientDto clientDto) {
        AddressEntity address = addressService.save(clientDto.getAddress());
        ClientEntity client = ClientConvertor.toEntity(clientDto);
        client.setAddress(address);
        return clientRepository.save(client);
    }
}
