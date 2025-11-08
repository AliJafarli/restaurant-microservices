package com.webdev.orders.controller;

import com.webdev.orders.entity.Order;
import com.webdev.orders.service.IOrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {
    
    private final IOrderService orderService;
    
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
       Order savedOrder = orderService.saveOrder(order);
       return ResponseEntity.ok(savedOrder);
    }
}
