package com.example.uniquindio.spring.Controller.interfaces.event;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.uniquindio.spring.dto.eventdto.AddCommentEvent;
import com.example.uniquindio.spring.dto.eventdto.CreateEventDto;
import com.example.uniquindio.spring.dto.eventdto.EditEventDto;
import com.example.uniquindio.spring.dto.eventdto.SearchidEventDto;
import com.example.uniquindio.spring.exception.event.EventException;
import com.example.uniquindio.spring.model.documents.Event;

public interface EventController {
    /**
     * save Event in DataBase
     *
     * @param eventdto
     * @return
     */
    public ResponseEntity<Event> saveEvent(@RequestBody() CreateEventDto eventdto);

    /**
     * inactuive Event in DatBase
     *
     * @param id
     * @return
     */
    public ResponseEntity<Event> deleteEvent(@PathVariable String id);

    /**
     * edit event in database
     *
     * @param eventdto
     * @return
     * @throws EventException
     */
    public ResponseEntity<Event> editEvent(@RequestBody() EditEventDto eventdto) throws EventException;

    /**
     * look for a event by name
     *
     * @param name
     * @return
     * @throws EventException
     */
    public ResponseEntity<String> findEventByName(@PathVariable String name) throws EventException;

    /**
     * look for a event by city
     * 
     * @param city
     * @return
     * @throws EventException
     */
    public ResponseEntity<String> findEventByCity(@PathVariable String city) throws EventException;

    /**
     * look for a event by type
     * 
     * @param eventType
     * @return
     * @throws EventException
     */
    public ResponseEntity<String> findEventByType(@PathVariable String eventType) throws EventException;

    /**
     * look for a event by date
     * 
     * @param saleStartDate
     * @return
     * @throws EventException
     */
    public ResponseEntity<List<Event>> findEventByDate(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate saleStartDate)
            throws EventException;

    /**
     * look all events and get up
     * 
     * @return
     * @throws EventException
     */
    public ResponseEntity<List<Event>> findEventAllEvents() throws EventException;

    /**
     * get statistical data of events
     * 
     * @param idEvent
     * @return
     * @throws EventException
     */
    public ResponseEntity<List<String>> getStatisticalData(@PathVariable String idEvent) throws EventException;

    public ResponseEntity<Optional<Event>> searchIEventId(@RequestBody() SearchidEventDto searchidEvent)
            throws Exception;

    public ResponseEntity<Event> addCommentEvent(@RequestBody() AddCommentEvent addCommentEvent) throws Exception;

}
