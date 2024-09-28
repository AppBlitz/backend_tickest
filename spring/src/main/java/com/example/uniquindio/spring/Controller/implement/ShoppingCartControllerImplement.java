package com.example.uniquindio.spring.Controller.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.uniquindio.spring.Controller.ShoppingCartController;
import com.example.uniquindio.spring.service.ShoppingCartService;

@RestController
@RequestMapping("/shoppingCart")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ShoppingCartControllerImplement implements ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;

}
