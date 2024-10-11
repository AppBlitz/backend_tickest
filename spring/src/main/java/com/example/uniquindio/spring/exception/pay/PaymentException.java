package com.example.uniquindio.spring.exception.pay;

public class PaymentException extends RuntimeException {
    public PaymentException(String message) {
        super(message);
    }
}
