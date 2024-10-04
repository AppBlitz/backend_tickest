package com.example.uniquindio.spring.service;

import com.example.uniquindio.spring.dto.EventDto;
import com.example.uniquindio.spring.exception.EventException;
import com.example.uniquindio.spring.model.documents.Event;
import com.example.uniquindio.spring.model.enums.EventType;
import com.example.uniquindio.spring.model.enums.StateEvent;
import com.example.uniquindio.spring.service.interfaces.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.uniquindio.spring.repository.EventRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EventService implements IEventService {

    @Autowired
    EventRepository eventRepository;


    @Override
    public Event saveEvent(EventDto eventdto) throws EventException {
        Event event=eventdtoTOEvent(eventdto);
        eventRepository.save(event);
        return event;
    }

    @Override
    public Event editEvent(EventDto eventdto) {

        return eventRepository.save(eventdtoTOEvent(eventdto));
    }

    @Override
    public Event deleteEvent(String id) {

        Optional<Event> event = eventRepository.findById(id);
        if (event.isPresent()) {
            Event updatedEvent = event.get();
            updatedEvent.setStateEvent(StateEvent.IDLE);
            eventRepository.save(updatedEvent);
            return updatedEvent;
        } else {
            throw new EventException("Evento no encontrado");
        }
    }

    @Override
    public List<Event> getAllEventsByCity(String city) {
        return eventRepository.findByCity(city);
    }

    @Override
    public List<Event> getAllEventsByName(String nameEvent) throws EventException {
        return eventRepository.findByNameEvent(nameEvent);
    }

    @Override
    public List<Event> getAllEventsByType(EventType eventType) {
        return eventRepository.findByEventType(eventType);
    }

    @Override
    public List<Event> getAllEvents() {return eventRepository.findAll();}

    public List<Event> getAllEventsByDate(LocalDateTime date) {
        return eventRepository.findByDate(date);
    }

    public Event eventdtoTOEvent(EventDto eventdto){
        Event event=new Event();
        //faltan tikets
        event.setNameEvent(eventdto.nameEvent());
        event.setAdressEvent(eventdto.adressEvent());
        event.setCity(eventdto.city());
        event.setDescriptionEvent(eventdto.descriptionEvent());
        event.setEventType(eventdto.eventType());
        event.setImageEvent(eventdto.imageEvent());
        event.setImageLocality(eventdto.imageLocality());
        event.setDate(eventdto.date());
        event.setLocality(eventdto.locality());
        event.setCapacity(eventdto.capacity());
        event.setComments(eventdto.comments());
        event.setStateEvent(eventdto.stateEvent());

        return event;
    }

}
