package com.example.glovoapiv2.dto;

import com.example.glovoapiv2.entity.ProductEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class OrderDto {

    List<ProductDto> products;
}
