package com.example.uniquindio.spring.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.uniquindio.spring.model.documents.ShoppingCart;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String> {

  Optional<ShoppingCart> findByName(String name, String identificationNumber);
}
