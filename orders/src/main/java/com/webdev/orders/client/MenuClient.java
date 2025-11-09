package com.webdev.orders.client;

import com.webdev.orders.dto.MenuDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "menu-service", url = "http://localhost:8082/api/menus")
public interface MenuClient {

    @GetMapping("/{id}")
    MenuDTO getMenuById(@PathVariable("id") Long id);
}
