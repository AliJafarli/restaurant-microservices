package com.webdev.orders.service.impl;

import com.webdev.customers.entity.Customer;
import com.webdev.orders.constants.OrdersConstants;
import com.webdev.orders.entity.Order;
import com.webdev.orders.repository.OrderRepository;
import com.webdev.orders.service.IOrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService implements IOrderService {

    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;

    @Override
    public Order saveOrder(Order order) {
        ResponseEntity<Customer> customerResponse = restTemplate.getForEntity(
                OrdersConstants.CUSTOMER_SERVICE_URL + order.getCustomerId(), Customer.class
        );
        if (!customerResponse.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Customer not found with id: " + order.getCustomerId());
        }
        order.setOrderDate(LocalDateTime.now());
        return orderRepository.save(order);

    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }
}
