package com.example.glovoapiv2.dto;

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
    private ClientDto client;
    private float cost;
    private List<ProductDto> products;
}
