package com.example.uniquindio.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uniquindio.spring.repository.ShoppingCartRepository;
import com.example.uniquindio.spring.service.interfaces.IShoppingCartService;

@Service
public class ShoppingCartService implements IShoppingCartService {

  @Autowired
  ShoppingCartRepository shoppingCartRepository;

}
