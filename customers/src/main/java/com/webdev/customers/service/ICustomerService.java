package com.webdev.customers.service;

import com.webdev.customers.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    void createCustomer(Customer customer);

    List<Customer> getAllCustomers();

    void updateCustomer(Customer customer);

    void deleteCustomer(Long id);

    Optional<Customer> getCustomerById(Long id);
}
