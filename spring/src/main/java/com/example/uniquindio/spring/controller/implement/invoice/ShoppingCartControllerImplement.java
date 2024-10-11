package com.example.uniquindio.spring.controller.implement.invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.uniquindio.spring.controller.interfaces.invoice.ShoppingCartController;
import com.example.uniquindio.spring.service.imp.invoice.ShoppingCartService;

@RestController
@RequestMapping("/shoppingCart")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ShoppingCartControllerImplement implements ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;

}
