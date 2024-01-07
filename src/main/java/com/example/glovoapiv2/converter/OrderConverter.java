package com.example.glovoapiv2.converter;

import com.example.glovoapiv2.dto.OrderDto;
import com.example.glovoapiv2.entity.OrderEntity;

import java.time.LocalDate;

public class OrderConverter {

    public static OrderDto toDto(OrderEntity order) {
        return OrderDto.builder()
                .id(order.getId())
                .date(order.getDate())
                .client(ClientConverter.toDto(order.getClient()))
                .cost(order.getCost())
                .products(order.getProducts().stream()
                        .map(ProductConverter::toDto).toList())
                .build();
    }

    public static OrderEntity toEntity(OrderDto order) {
        return OrderEntity.builder()
                .date(LocalDate.now())
                .client(ClientConverter.toEntity(order.getClient()))
                .products(order.getProducts().stream()
                        .map(ProductConverter::toEntity).toList())
                .build();
    }
}
