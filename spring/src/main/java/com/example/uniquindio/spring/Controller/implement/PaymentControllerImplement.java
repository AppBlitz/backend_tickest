package com.example.uniquindio.spring.Controller.implement;

import com.example.uniquindio.spring.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("payment")
public class PaymentControllerImplement {
    @Autowired
    PaymentService paymentService;

    @Value("${mercado_pago_access_token}")
    private String mercadoPagoAccessToken;



}
