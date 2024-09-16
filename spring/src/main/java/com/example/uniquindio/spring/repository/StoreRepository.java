package com.example.uniquindio.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.uniquindio.spring.model.documents.Store;

public interface StoreRepository extends MongoRepository<Store, String> {

}
