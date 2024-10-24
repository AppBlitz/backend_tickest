package com.example.uniquindio.spring.Controller.implement.event;

import com.example.uniquindio.spring.Controller.interfaces.event.EventController;
import com.example.uniquindio.spring.dto.eventdto.CreateEventDto;
import com.example.uniquindio.spring.dto.eventdto.EditEventDto;
import com.example.uniquindio.spring.exception.event.EventException;
import com.example.uniquindio.spring.model.documents.Event;
import com.example.uniquindio.spring.model.enums.EventType;
import com.example.uniquindio.spring.repository.EventRepository;
import com.example.uniquindio.spring.service.imp.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("event")
public class EventControllerImplement implements EventController {

    @Autowired
    EventService eventService;

    /**
     * TODO: method create user
     *
     * @param eventdto
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Event> saveEvent(@RequestBody() CreateEventDto eventdto) {
        Event event= eventService.saveEvent((eventdto));
        return ResponseEntity.status(200).body(event);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Event> deleteEvent(@PathVariable String id) {
        Event e=eventService.deleteEvent(id);
        return ResponseEntity.status(200).body(e);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public ResponseEntity<Event> editEvent(@RequestBody() EditEventDto eventdto) throws EventException {
        Event e= eventService.editEvent(eventdto);
        return ResponseEntity.status(200).body(e);
    }

    @RequestMapping(value ="/findByName/{name}", method = RequestMethod.GET)
    public ResponseEntity<String> findEventByName(@PathVariable String name) throws EventException {
        List<Event> e = eventService.getAllEventsByName(name);
        return ResponseEntity.status(200).body("eventos cargados: "+e.size());
    }

    @RequestMapping(value ="/findByCity/{city}", method = RequestMethod.GET)
    public ResponseEntity<String> findEventByCity(@PathVariable String city) throws EventException {
        List<Event> e = eventService.getAllEventsByCity(city);
        return ResponseEntity.status(200).body("eventos cargados: "+e.size());
    }

    @RequestMapping(value ="/findByType/{eventType}", method = RequestMethod.GET)
    public ResponseEntity<String> findEventByType(@PathVariable String eventType) throws EventException {
        List<Event> e = eventService.getAllEventsByType(EventType.valueOf(eventType.toUpperCase()));
        return ResponseEntity.status(200).body("eventos cargados: "+e.size());
    }

    @RequestMapping(value ="/findByDate/{saleStartDate}", method = RequestMethod.GET)
    public ResponseEntity<List<Event>> findEventByDate
            (@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate saleStartDate)  throws EventException {

        List<Event> events = eventService.getAllEventsByDate(saleStartDate);
        return ResponseEntity.status(200).body(events);


    }

    @Override
    @RequestMapping(value = "/generarReporte/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getStatisticalData(@PathVariable String id) throws EventException {
        List<String> statisticalData = eventService.getStatisticalData(id);
        return ResponseEntity.status(200).body(statisticalData);
    }


}


