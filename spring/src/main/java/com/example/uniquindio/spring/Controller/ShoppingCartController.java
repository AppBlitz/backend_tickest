package com.example.uniquindio.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.uniquindio.spring.service.ShoppingCartService;

@RestController
@RequestMapping("/shoppingCart")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ShoppingCartController {

  @Autowired
  ShoppingCartService shoppingCartService;

}
