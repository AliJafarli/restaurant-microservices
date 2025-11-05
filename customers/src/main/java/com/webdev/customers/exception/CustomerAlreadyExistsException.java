package com.webdev.customers.exception;

public class CustomerAlreadyExistsException  extends RuntimeException {
    public CustomerAlreadyExistsException(String message) {
        super(message);
    }
}
