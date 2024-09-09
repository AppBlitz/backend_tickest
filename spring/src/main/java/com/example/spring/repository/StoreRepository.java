package com.example.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.spring.model.documents.Store;

public interface StoreRepository extends MongoRepository<Store, String> {

}
