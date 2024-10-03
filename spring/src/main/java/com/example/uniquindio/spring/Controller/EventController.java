package com.example.uniquindio.spring.Controller;

import com.example.uniquindio.spring.dto.EventDto;
import com.example.uniquindio.spring.model.documents.Event;
import com.example.uniquindio.spring.service.EventService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.Document;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("event")
public class EventController {

    @Autowired
    EventService eventService;

    /**
     * TODO: method create user
     *
     * @param eventdto
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Event> saveEvent(@RequestBody() EventDto eventdto) throws Exception {
               Event event= eventService.saveEvent((eventdto));
               return ResponseEntity.status(200).body(event);


    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteEvent(@PathVariable String id) throws Exception {
        eventService.deleteEvent(id);
        return ResponseEntity.ok("deleted succesfull");
    }



}


