package com.example.uniquindio.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.uniquindio.spring.dto.ShoppingCartDto;
import com.example.uniquindio.spring.model.documents.ShoppingCart;
import com.example.uniquindio.spring.service.ShoppingCartService;

@RestController
@RequestMapping("/shoppingCart")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ShoppingCartControllerController {

  @Autowired
  ShoppingCartService shoppingCartService;

  /**
   * TODO: doccument
   * 
   * @param shoppingCartDto
   * @return
   */
  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public ResponseEntity<ShoppingCart> createCart(@PathVariable() ShoppingCartDto shoppingCartDto) {

    ShoppingCart cart = shoppingCartService.createShoppingCart(shoppingCartDto);
    if (cart == null) {
      return ResponseEntity.status(400).body(null);
    } else {
      return ResponseEntity.status(200).body(cart);

    }
  }
}
