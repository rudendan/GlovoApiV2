package com.example.glovoapiv2.convertor;

import com.example.glovoapiv2.dto.ProductDto;
import com.example.glovoapiv2.entity.ProductEntity;

public class ProductConvertor {

    public static ProductDto toProductDto(ProductEntity product) {
        return ProductDto.builder()
                .name(product.getName())
                .cost(product.getCost())
                .build();
    }
}
