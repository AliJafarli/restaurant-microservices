package com.webdev.orders.controller;

import com.webdev.orders.dto.OrderDetailDTO;
import com.webdev.orders.entity.Order;
import com.webdev.orders.service.IOrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<OrderDetailDTO> getOrderDetail(@PathVariable Long id) {
        OrderDetailDTO detail = orderService.getOrderDetail(id);
        return ResponseEntity.ok(detail);
    }
}
