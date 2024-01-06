package com.example.glovoapiv2.service;

import com.example.glovoapiv2.convertor.ProductConvertor;
import com.example.glovoapiv2.dto.ProductDto;
import com.example.glovoapiv2.entity.ProductEntity;
import com.example.glovoapiv2.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductEntity get(int id) {
        return productRepository.findById(id).orElseThrow();
    }

    public List<ProductEntity> saveAll(List<ProductDto> productsDto) {
        List<ProductEntity> productsEntity = productsDto.stream()
                .map(ProductConvertor::toEntity).toList();
        return productRepository.saveAll(productsEntity);
    }

    public List<ProductEntity> getByIds(List<ProductDto> productsDto) {
        List<Integer> ids = productsDto.stream().map(ProductDto::getId).toList();
        return productRepository.findAllById(ids);
    }

    public float sum(List<ProductEntity> products) {
        float cost = 0.0f;

        for (ProductEntity product : products) {
            cost += product.getCost();
        }
        return cost;
    }
}
