package com.example.glovoapiv2.controller;

import com.example.glovoapiv2.convertor.ProductConvertor;
import com.example.glovoapiv2.dto.ProductDto;
import com.example.glovoapiv2.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ProductDto get (@PathVariable int id) {
        return ProductConvertor.toDto(productService.get(id));
    }
}
