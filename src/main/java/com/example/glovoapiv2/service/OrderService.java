package com.example.glovoapiv2.service;

import com.example.glovoapiv2.convertor.OrderConvertor;
import com.example.glovoapiv2.dto.OrderDto;
import com.example.glovoapiv2.entity.OrderEntity;
import com.example.glovoapiv2.entity.ProductEntity;
import com.example.glovoapiv2.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private ProductService productService;

    @Autowired
    public OrderService(OrderRepository orderRepository, ProductService productService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
    }

    public OrderEntity get(int id) {
        return orderRepository.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
    }

    public OrderDto create(OrderDto order) {
        List<ProductEntity> products = productService.getByIds(order.getProducts());
        OrderEntity orderEntity = OrderConvertor.toEntity(order);
        if(products != null) {
            orderEntity.setProducts(products);
            orderEntity.setCost(productService.sum(orderEntity.getProducts()));
        }
        return OrderConvertor.toDto(orderRepository.save(orderEntity));
    }

    public void delete(int id) {
        OrderEntity order = get(id);
        orderRepository.delete(order);
    }

    public OrderDto addProduct(int orderId, int productId) {
        OrderEntity order = get(orderId);
        ProductEntity product = productService.get(productId);
        if(product != null) {
            order.getProducts().add(product);
            order.setCost(productService.sum(order.getProducts()));
        }
        return OrderConvertor.toDto(orderRepository.save(order));
    }

    public OrderDto remove(int orderId, int productId) {
        OrderEntity order = get(orderId);
        ProductEntity product = productService.get(productId);
        if(product != null) {
            order.getProducts().remove(product);
            order.setCost(productService.sum(order.getProducts()));
        }
        return OrderConvertor.toDto(orderRepository.save(order));
    }

    public OrderDto update(OrderDto orderDto) {
        OrderEntity order = get(orderDto.getId());
        List<ProductEntity> productEntities = productService.getByIds(orderDto.getProducts());
        if (productEntities != null) {
            order.setProducts(productEntities);
            order.setCost(productService.sum(productEntities));
        }
        if (orderDto.getName() != null) order.setName(orderDto.getName());
        if (orderDto.getAddress() != null) order.setAddress(orderDto.getAddress());
        return OrderConvertor.toDto(orderRepository.save(order));
    }
}
