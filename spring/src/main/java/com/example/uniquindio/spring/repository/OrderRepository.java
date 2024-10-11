package com.example.uniquindio.spring.repository;

import com.example.uniquindio.spring.model.documents.PurchaseOrder;
import com.example.uniquindio.spring.model.documents.ShoppingCart;
import com.example.uniquindio.spring.model.documents.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends MongoRepository<PurchaseOrder, String> {
    Optional<PurchaseOrder> findByShoppingCart(ShoppingCart shoppingCart);
}
