package com.example.glovoapiv2.converter;

import com.example.glovoapiv2.dto.ProductDto;
import com.example.glovoapiv2.entity.ProductEntity;

public class ProductConverter {

    public static ProductDto toDto(ProductEntity product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .cost(product.getCost())
                .build();
    }

    public static ProductEntity toEntity(ProductDto product) {
        return ProductEntity.builder()
                .name(product.getName())
                .cost(product.getCost())
                .build();
    }
}
