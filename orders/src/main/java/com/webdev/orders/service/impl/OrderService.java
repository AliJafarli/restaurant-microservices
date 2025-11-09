package com.webdev.orders.service.impl;

import com.webdev.orders.client.CustomerClient;
import com.webdev.orders.client.MenuClient;
import com.webdev.orders.dto.CustomerDTO;
import com.webdev.orders.dto.MenuDTO;
import com.webdev.orders.dto.OrderDetailDTO;
import com.webdev.orders.entity.Order;
import com.webdev.orders.repository.OrderRepository;
import com.webdev.orders.service.IOrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService implements IOrderService {

    private final OrderRepository orderRepository;
    private final CustomerClient customerClient;
    private final MenuClient menuClient;


    @Override
    public Order saveOrder(Order order) {
        CustomerDTO customer = customerClient.getCustomerById(order.getCustomerId());

        if (customer == null) {
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

    @Override
    public OrderDetailDTO getOrderDetail(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));

        CustomerDTO customer = customerClient.getCustomerById(order.getCustomerId());
        MenuDTO menu = menuClient.getMenuById(order.getMenuId());

        return new OrderDetailDTO(customer.getName(), menu.getName(), order.getOrderDate());
    }


}
