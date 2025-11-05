package com.webdev.customers.controller;

import com.webdev.customers.entity.Customer;
import com.webdev.customers.service.ICustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController {

    private final ICustomerService customerService;

public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
    customerService.createCustomer(customer);
    return ResponseEntity.ok("Customer created and added to the database!");
}

}
