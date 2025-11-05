package com.webdev.customers.service;

import com.webdev.customers.entity.Customer;

import java.util.List;

public interface ICustomerService {

    void createCustomer(Customer customer);

    List<Customer> getAllCustomers();

    void updateCustomer(Customer customer);
}
