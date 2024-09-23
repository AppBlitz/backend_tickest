package com.example.uniquindio.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.uniquindio.spring.model.documents.Event;

public interface EventRepository extends MongoRepository<Event, String> {

}