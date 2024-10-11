package com.example.uniquindio.spring.service.imp.event;

import com.example.uniquindio.spring.dto.eventdto.CreateEventDto;
import com.example.uniquindio.spring.dto.eventdto.EditEventDto;
import com.example.uniquindio.spring.exception.event.EventException;
import com.example.uniquindio.spring.model.documents.Event;
import com.example.uniquindio.spring.model.enums.EventType;
import com.example.uniquindio.spring.model.enums.StateEvent;
import com.example.uniquindio.spring.service.interfaces.event.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.uniquindio.spring.repository.EventRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EventService implements IEventService {

    @Autowired
    EventRepository eventRepository;


    @Override
    public Event saveEvent(CreateEventDto eventdto) throws EventException {
        Event event=eventdtoTOEvent(eventdto);
        eventRepository.save(event);
        return event;
    }

    @Override
    public Event editEvent(EditEventDto eventdto) {
        Optional<Event> e = eventRepository.findById(eventdto.id());
        Event event;
        if(e.isPresent()){
            event=eventdtoTOEvent(e.get(),eventdto);
            return eventRepository.save(event);
        }else{
            throw new EventException("evento no encontrado");
        }
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

    public Event getEventById(String id){
        Optional<Event> e = eventRepository.findById(id);
        if(e.isPresent()){
            return e.get();
        }else{
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

    public List<Event> getAllEventsByDate(LocalDate saleStartDate) {

        return eventRepository.findBysaleStartDate(saleStartDate);
    }

    public Event eventdtoTOEvent(CreateEventDto eventdto){
        Event event=new Event();

        event.setNameEvent(eventdto.nameEvent());
        event.setAdressEvent(eventdto.adressEvent());
        event.setCity(eventdto.city());
        event.setDescriptionEvent(eventdto.descriptionEvent());
        event.setEventType(eventdto.eventType());
        event.setImageEvent(eventdto.imageEvent());
        event.setEventDate(eventdto.eventDate());
        event.setEventTime(eventdto.eventTime());
        event.setSaleStartDate(eventdto.saleStartDate());
        event.setSaleStartTime(eventdto.saleStartTime());
        event.setLocality(eventdto.locality());
        event.setCapacityMax(eventdto.capacityMax());
        event.setCapacity(eventdto.capacity());
        event.setComments(eventdto.comments());
        event.setStateEvent(eventdto.stateEvent());

        return event;
    }

    public Event eventdtoTOEvent(Event event,EditEventDto eventdto){

        event.setNameEvent(eventdto.nameEvent());
        event.setAdressEvent(eventdto.adressEvent());
        event.setCity(eventdto.city());
        event.setDescriptionEvent(eventdto.descriptionEvent());
        event.setEventType(eventdto.eventType());
        event.setImageEvent(eventdto.imageEvent());
        event.setEventDate(eventdto.eventDate());
        event.setEventTime(eventdto.eventTime());
        event.setSaleStartDate(eventdto.saleStartDate());
        event.setSaleStartTime(eventdto.saleStartTime());
        event.setLocality(eventdto.locality());
        event.setCapacityMax(eventdto.capacityMax());
        event.setCapacity(eventdto.capacity());
        event.setComments(eventdto.comments());
        event.setStateEvent(eventdto.stateEvent());



        return event;
    }

}
