package com.example.uniquindio.spring.Controller.interfaces.event;

import com.example.uniquindio.spring.dto.eventdto.CreateEventDto;
import com.example.uniquindio.spring.dto.eventdto.EditEventDto;
import com.example.uniquindio.spring.exception.event.EventException;
import com.example.uniquindio.spring.model.documents.Event;
import com.example.uniquindio.spring.model.enums.EventType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.util.List;

public interface EventController {

    public ResponseEntity<Event> saveEvent(@RequestBody() CreateEventDto eventdto) ;

    public ResponseEntity<Event> deleteEvent(@PathVariable String id);


    public ResponseEntity<Event> editEvent(@RequestBody() EditEventDto eventdto) throws EventException;


    public ResponseEntity<String> findEventByName(@PathVariable String name) throws EventException ;

    public ResponseEntity<String> findEventByCity(@PathVariable String city) throws EventException ;


    public ResponseEntity<String> findEventByType(@PathVariable String eventType) throws EventException;


    public ResponseEntity<List<Event>> findEventByDate
            (@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate saleStartDate)
            throws EventException;

    public ResponseEntity<List<String>> getStatisticalData(@PathVariable String idEvent) throws EventException;
}
