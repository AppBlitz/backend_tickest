package com.example.uniquindio.spring.Controller;

import com.example.uniquindio.spring.dto.EventDto;
import com.example.uniquindio.spring.model.documents.Event;
import com.example.uniquindio.spring.model.enums.EventType;
import com.example.uniquindio.spring.repository.EventRepository;
import com.example.uniquindio.spring.service.EventService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.Document;
import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("event")
public class EventController {

    @Autowired
    EventService eventService;
    @Autowired
    private EventRepository eventRepository;

    /**
     * TODO: method create user
     *
     * @param eventdto
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Event> saveEvent(@RequestBody() EventDto eventdto) {
        Event event= eventService.saveEvent((eventdto));
        return ResponseEntity.status(200).body(event);


    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Event> deleteEvent(@PathVariable String id) {
        Event e=eventService.deleteEvent(id);
        return ResponseEntity.status(200).body(e);
    }

    @RequestMapping(value ="/findByName/{name}", method = RequestMethod.GET)
    public ResponseEntity<String> findEventByName(@PathVariable String name) {
        List<Event> e = eventService.getAllEventsByName(name);
        return ResponseEntity.status(200).body("eventos cargados: "+e.size());
    }

    @RequestMapping(value ="/findByCity/{city}", method = RequestMethod.GET)
    public ResponseEntity<String> findEventByCity(@PathVariable String city) {
        List<Event> e = eventService.getAllEventsByCity(city);
        return ResponseEntity.status(200).body("eventos cargados: "+e.size());
    }

    @RequestMapping(value ="/findByType/{type}", method = RequestMethod.GET)
    public ResponseEntity<String> findEventByType(@PathVariable String type) {
        List<Event> e = eventService.getAllEventsByType(EventType.valueOf(type));
        return ResponseEntity.status(200).body("eventos cargados: "+e.size());
    }

    @RequestMapping(value ="/findByDate/{date}", method = RequestMethod.GET)
    public ResponseEntity<String> findEventByDate(@PathVariable String date) {
        List<Event> e = eventService.getAllEventsByDate(LocalDateTime.parse(date));
        return ResponseEntity.status(200).body("eventos cargados: "+e.size());
    }



}


