package com.example.uniquindio.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uniquindio.spring.repository.ShoppingCartRepository;

@Service
public class ShoppingCartService {

  @Autowired
  ShoppingCartRepository shoppingCartRepository;

}
