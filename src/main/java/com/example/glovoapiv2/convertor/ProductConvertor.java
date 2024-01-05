package com.example.glovoapiv2.convertor;

import com.example.glovoapiv2.dto.ProductDto;
import com.example.glovoapiv2.entity.ProductEntity;

public class ProductConvertor {

    public static ProductDto toProductDto(ProductEntity product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .cost(product.getCost())
                .build();
    }

    public static ProductEntity toProductEntity(ProductDto product) {
        return ProductEntity.builder()
                .name(product.getName())
                .cost(product.getCost())
                .build();
    }
}
