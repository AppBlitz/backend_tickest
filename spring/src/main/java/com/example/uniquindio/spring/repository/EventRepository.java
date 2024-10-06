package com.example.uniquindio.spring.repository;

import com.example.uniquindio.spring.model.enums.EventType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.uniquindio.spring.model.documents.Event;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {

    List<Event> findBysaleStartDate(LocalDate saleStartDate);

    List<Event> findByNameEvent(String nameEvent);

    List<Event> findByCity(String city);

    List<Event> findByEventType(EventType eventType);

}