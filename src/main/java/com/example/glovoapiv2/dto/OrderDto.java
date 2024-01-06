package com.example.glovoapiv2.dto;

import com.example.glovoapiv2.entity.ProductEntity;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private int id;
    private LocalDate date;
    private String name;
    private String address;
    private float cost;
    List<ProductDto> products;
}
