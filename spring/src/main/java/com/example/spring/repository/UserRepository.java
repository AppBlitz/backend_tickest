package com.example.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.model.documents.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
