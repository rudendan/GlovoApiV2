package com.example.glovoapiv2.controller;

import com.example.glovoapiv2.convertor.OrderConvertor;
import com.example.glovoapiv2.dto.OrderDto;
import com.example.glovoapiv2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public OrderDto get(@PathVariable int id) {
        return OrderConvertor.toOrderDto(orderService.get(id));
    }

    @PostMapping
    public OrderDto create(@RequestBody OrderDto order) {
        return orderService.create(order);
    }

    @PatchMapping("/{orderId}/product/{productId}")
    public OrderDto addProduct(@PathVariable int orderId, @PathVariable int productId) {
        return orderService.addProduct(orderId, productId);
    }

    @DeleteMapping
    public void delete() {};
}
