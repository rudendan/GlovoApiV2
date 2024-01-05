package com.example.glovoapiv2.service;

import com.example.glovoapiv2.convertor.OrderConvertor;
import com.example.glovoapiv2.dto.OrderDto;
import com.example.glovoapiv2.entity.OrderEntity;
import com.example.glovoapiv2.entity.ProductEntity;
import com.example.glovoapiv2.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private ProductService productService;

    @Autowired
    public OrderService(OrderRepository orderRepository, ProductService productService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
    }

    public OrderEntity get(int id) {
        return orderRepository.findById(id).orElseThrow();
    }

    public OrderDto create(OrderDto order) {

        List<ProductEntity> productEntities = productService.getByIds(order.getProducts());
        OrderEntity orderEntity = OrderConvertor.toOrderEntity(order);
        orderEntity.setProducts(productEntities);
        orderEntity.setCost(sum(orderEntity.getProducts()));
        return OrderConvertor.toOrderDto(orderRepository.save(orderEntity));
    }

    public void delete(int id) {
       orderRepository.deleteById(id);
    }

    public OrderDto addProduct(int orderId, int productId) {
        OrderEntity order = get(orderId);
        ProductEntity product = productService.get(productId);
        order.getProducts().add(product);
        order.setCost(sum(order.getProducts()));
        return OrderConvertor.toOrderDto(order);
    }

    public float sum(List<ProductEntity> products) {
        float cost = 0.0f;

        for (ProductEntity product : products) {
            cost += product.getCost();
        }
        return cost;
    }
}
