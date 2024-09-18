package com.example.uniquindio.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uniquindio.spring.dto.ShoppingCartDto;
import com.example.uniquindio.spring.model.documents.ShoppingCart;
import com.example.uniquindio.spring.repository.ShoppingCartRepository;

@Service
public class ShoppingCartService {

  @Autowired
  ShoppingCartRepository shoppingCartRepository;

  /**
   * TODO: Method create shopping cart
   * 
   * @param shoppingCartdto
   * @return
   */
  public ShoppingCart createShoppingCart(ShoppingCartDto shoppingCartdto) {
    ShoppingCart cart = null;
    Optional<ShoppingCart> cartShop = shoppingCartRepository.findByName(shoppingCartdto.nameUser(),
        shoppingCartdto.indentificationNumber());
    if (cartShop == null) {
      return null;
    } else {
      cart = new ShoppingCart();
    }

    return cart;
  }

}
