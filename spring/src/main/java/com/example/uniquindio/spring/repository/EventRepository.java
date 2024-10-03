package com.example.uniquindio.spring.repository;

import com.example.uniquindio.spring.model.enums.EventType;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.uniquindio.spring.model.documents.Event;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {

    Optional<Event> findById(String id);

    List<Event> findByNameEvent(String nameEvent);

    List<Event> findByCity(String city);

    List<Event> findByEventType(EventType eventType);

}