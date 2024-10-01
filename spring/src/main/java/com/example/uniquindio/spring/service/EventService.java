package com.example.uniquindio.spring.service;

import com.example.uniquindio.spring.dto.EventDto;
import com.example.uniquindio.spring.model.documents.Event;
import com.example.uniquindio.spring.model.enums.EventType;
import com.example.uniquindio.spring.service.interfaces.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.uniquindio.spring.repository.EventRepository;

import java.util.List;

@Service
public class EventService implements IEventService {

@Autowired
EventRepository eventRepository;


    @Override
    public void saveOrEditEvent(EventDto eventdto) {
        Event event=new Event(eventdto.nameEvent(),eventdto.adressEvent(),eventdto.city(), eventdto.descriptionEvent(),
                eventdto.eventType(), eventdto.imageEvent(), eventdto.imageLocality(),eventdto.date(),eventdto.locality(),
                eventdto.comments(),eventdto.stateEvent());
        eventRepository.save(event);
    }

    @Override
    public void deleteEvent(EventDto eventdto) {

    }

    @Override
    public void generateReports(Event event) {

    }

    @Override
    public List<Event> getAllEventsByCity(String city) {
        return List.of();
    }

    @Override
    public List<Event> getAllEventsByName(String nameEvent) {
        return List.of();
    }

    @Override
    public List<Event> getAllEventsByType(EventType eventType) {
        return List.of();
    }

    @Override
    public List<Event> getAllEvents() {
        return List.of();
    }

}
