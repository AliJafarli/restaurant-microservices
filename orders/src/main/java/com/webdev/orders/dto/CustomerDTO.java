package com.webdev.orders.dto;

import lombok.Data;

@Data
public class CustomerDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;
}
