package com.example.uniquindio.spring.exception.pay;

import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;

public class MpException extends Throwable {
    public MpException(String message) throws MPApiException,MPException {
        super(message);
    }
}
