package com.webdev.orders.client;

import com.webdev.orders.dto.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service", url = "http://localhost:8080/api/customers")
public interface CustomerClient {

    @GetMapping("/{id}")
    CustomerDTO getCustomerById(@PathVariable("id") Long id);
}
