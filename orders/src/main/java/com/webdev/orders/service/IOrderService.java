package com.webdev.orders.service;

import com.webdev.orders.entity.Order;

import java.util.List;

public interface IOrderService {

    Order saveOrder(Order order);

    List<Order> getAllOrders();
}
