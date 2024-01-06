package com.example.glovoapiv2.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@Entity(name = "orders")
@ToString(exclude = "products")
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    private String name;
    private String address;
    private float cost;
    @ManyToMany
    @JoinTable(name = "orders_products",
            joinColumns = @JoinColumn(name = "orders_id", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "products_id", referencedColumnName = "ID")
    )
    private List<ProductEntity> products;

}
