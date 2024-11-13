package com.example.uniquindio.spring.repository;

import com.example.uniquindio.spring.model.enums.EventType;
import com.example.uniquindio.spring.model.enums.StateEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.uniquindio.spring.model.documents.Event;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {

    @Query("{ nameEvent: { $regex: ?0, $options: 'i' } }")
    List<Event> findByNameEvent(String nameEvent);

    // @Query("{ saleStartDate: { $regex: ?0, $options: 'i' } }")
    List<Event> findBysaleStartDate(LocalDate saleStartDate);

    List<Event> findByEventDate(LocalDate saleStartDate);

    @Query("{ city: { $regex: ?0, $options: 'i' } }")
    List<Event> findByCity(String city);

    // @Query("{ eventType: { $regex: ?0, $options: 'i' } }")
    List<Event> findByEventType(EventType eventType);

    List<Event> findEventsByStateEvent(StateEvent stateEvent);

    Optional<Event> findById(String id);
}
