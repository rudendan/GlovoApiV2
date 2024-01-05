package com.example.glovoapiv2.service;

import com.example.glovoapiv2.convertor.OrderConvertor;
import com.example.glovoapiv2.dto.OrderDto;
import com.example.glovoapiv2.entity.OrderEntity;
import com.example.glovoapiv2.entity.ProductEntity;
import com.example.glovoapiv2.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private ProductService productService;

    @Autowired
    public OrderService(OrderRepository orderRepository, ProductService productService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
    }

    public OrderDto getById(int id) {
        return orderRepository.findById(id).map(OrderConvertor::toOrderDto).orElseThrow();
    }

    public OrderDto create(OrderDto order) {

        List<ProductEntity> productEntities = productService.save(order.getProducts());
        OrderEntity orderEntity = OrderConvertor.toOrderEntity(order);
        orderEntity.setProducts(productEntities);
        return OrderConvertor.toOrderDto(orderRepository.save(orderEntity));
    }
}
