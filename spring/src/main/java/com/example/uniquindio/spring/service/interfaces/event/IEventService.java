package com.example.uniquindio.spring.service.interfaces.event;

import com.example.uniquindio.spring.dto.eventdto.CreateEventDto;
import com.example.uniquindio.spring.dto.eventdto.EditEventDto;
import com.example.uniquindio.spring.exception.event.EventException;
import com.example.uniquindio.spring.model.documents.Event;
import com.example.uniquindio.spring.model.enums.EventType;
import com.example.uniquindio.spring.model.enums.StateEvent;

import java.time.LocalDate;
import java.util.List;

public interface IEventService {
    /**
     * save Event in DataBase
     *
     * @param eventdto
     * @return
     */
    public Event saveEvent(CreateEventDto eventdto) throws EventException;

    /**
     * edit event in database
     *
     * @param eventdto
     * @return
     * @throws EventException
     */
    public Event editEvent(EditEventDto eventdto);

    /**
     * inactuive Event in DatBase
     *
     * @param id
     * @return
     */
    public Event deleteEvent(String id);

    /**
     * look for a event by city
     * @param city
     * @return
     */
    public List<Event> getAllEventsByCity(String city);

    /**
     * look for a event by name
     *
     * @param nameEvent
     * @return
     * @throws EventException
     */
    public List<Event> getAllEventsByName(String nameEvent);

    /**
     * look for a event by type
     * @param eventType
     * @return
     */
    public List<Event> getAllEventsByType(EventType eventType);
    /**
     * look for a event by date
     * @param dateEvent
     * @return
     */
    public List<Event> getAllEventsByDateEvent(LocalDate dateEvent);

    /**
     * look for a event by date
     * @param saleStartDate
     * @return
     */
    public List<Event> getAllEventsByDate(LocalDate saleStartDate);

    /**
     * get all events in database
     * @return
     */
    public List<Event> getAllEvents();

    /**
     * look for a event by state
     * @param stateEvent
     * @return
     */
    public List<Event> getEventsByState(StateEvent stateEvent);

    /**
     * get statistical data of events
     *
     * @param id
     * @return
     */
    public List<String> getStatisticalData(String id) ;

}
