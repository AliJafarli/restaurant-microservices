package com.webdev.customers.service.impl;

import com.webdev.customers.entity.Customer;
import com.webdev.customers.exception.CustomerAlreadyExistsException;
import com.webdev.customers.repository.CustomerRepository;
import com.webdev.customers.service.ICustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public void createCustomer(Customer customer) {
        Optional<Customer> optionalCustomer = customerRepository.findCustomerByEmail(customer.getEmail());
        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException(String.format(
                    "Customer with email %s already exists", customer.getEmail()));
        }
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
