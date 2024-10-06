package com.example.uniquindio.spring.service.interfaces;

import com.example.uniquindio.spring.dto.eventdto.CreateEventDto;
import com.example.uniquindio.spring.dto.eventdto.EditEventDto;
import com.example.uniquindio.spring.model.documents.Event;
import com.example.uniquindio.spring.model.enums.EventType;

import java.time.LocalDate;
import java.util.List;

public interface IEventService {

    public Event saveEvent(CreateEventDto eventdto);

    public Event editEvent(EditEventDto eventdto);


    public Event deleteEvent(String id);

    public List<Event> getAllEventsByCity(String city);

    public List<Event> getAllEventsByName(String nameEvent);

    public List<Event> getAllEventsByType(EventType eventType);

    public List<Event> getAllEventsByDate(LocalDate saleStartDate);

    public List<Event> getAllEvents();


}
