package com.example.uniquindio.spring.service.interfaces;

import com.example.uniquindio.spring.dto.EventDto;
import com.example.uniquindio.spring.model.documents.Event;
import com.example.uniquindio.spring.model.enums.EventType;
import org.bson.types.ObjectId;

import java.util.List;

public interface IEventService {

    public Event saveEvent(EventDto eventdto);

    public void editEvent(EventDto eventdto);

    public void deleteEvent(String id);

    public void generateReports(Event event);

    public List<Event> getAllEventsByCity(String city);

    public List<Event> getAllEventsByName(String nameEvent);

    public List<Event> getAllEventsByType(EventType eventType);

    public List<Event> getAllEvents();


}
