package com.example.glovoapiv2.convertor;

import com.example.glovoapiv2.dto.OrderDto;
import com.example.glovoapiv2.entity.OrderEntity;

import java.time.LocalDate;

public class OrderConvertor {

    public static OrderDto toDto(OrderEntity order) {
        return OrderDto.builder()
                .id(order.getId())
                .date(order.getDate())
                .name(order.getName())
                .address(order.getAddress())
                .cost(order.getCost())
                .products(order.getProducts().stream()
                        .map(ProductConvertor::toDto).toList())
                .build();
    }

    public static OrderEntity toEntity(OrderDto order) {
        return OrderEntity.builder()
                .date(LocalDate.now())
                .name(order.getName())
                .address(order.getAddress())
                .products(order.getProducts().stream()
                        .map(ProductConvertor::toEntity).toList())
                .build();
    }
}
