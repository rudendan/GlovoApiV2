package com.example.glovoapiv2.controller;

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
    public OrderDto getById(@PathVariable int id) {
        return orderService.getById(id);
    }

    @PostMapping
    public OrderDto create(@RequestBody OrderDto order) {
        return orderService.create(order);
    }
}
