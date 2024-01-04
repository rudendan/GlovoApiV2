package com.example.glovoapiv2.convertor;

import com.example.glovoapiv2.dto.OrderDto;
import com.example.glovoapiv2.entity.OrderEntity;

public class OrderConvertor {
    public static OrderDto toOrderDto(OrderEntity order) {
        return OrderDto.builder()
                .products(order.getProducts().stream()
                        .map(ProductConvertor::toProductDto).toList())
                .build();
    }
}
