package com.example.uniquindio.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.uniquindio.spring.model.documents.ShoppingCart;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String> {

}