package com.example.glovoapiv2.service;

import com.example.glovoapiv2.convertor.OrderConvertor;
import com.example.glovoapiv2.dto.OrderDto;
import com.example.glovoapiv2.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderDto getById(int id) {
        return orderRepository.findById(id).map(OrderConvertor::toOrderDto).orElseThrow();
    }
}
