package com.example.glovoapiv2.convertor;

import com.example.glovoapiv2.dto.OrderDto;
import com.example.glovoapiv2.dto.ProductDto;
import com.example.glovoapiv2.entity.OrderEntity;

import java.time.LocalDate;

public class OrderConvertor {

    public static OrderDto toOrderDto(OrderEntity order) {
        return OrderDto.builder()
                .id(order.getId())
                .date(order.getDate())
                .cost(order.getCost())
                .products(order.getProducts().stream()
                        .map(ProductConvertor::toProductDto).toList())
                .build();
    }

    public static OrderEntity toOrderEntity(OrderDto order) {


        return OrderEntity.builder()
                .date(LocalDate.now())
                .products(order.getProducts().stream()
                        .map(ProductConvertor::toProductEntity).toList())
                .build();
    }
}
