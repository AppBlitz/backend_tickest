package com.example.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.spring.model.documents.Event;

public interface EventRepository extends MongoRepository<Event, String> {

}
