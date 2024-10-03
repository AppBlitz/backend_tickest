package com.example.uniquindio.spring.model.documents;

import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import lombok.*;
import org.springframework.data.annotation.Id;

import com.example.uniquindio.spring.model.enums.EventType;
import com.example.uniquindio.spring.model.enums.StateEvent;
import com.example.uniquindio.spring.model.vo.Comment;

import com.example.uniquindio.spring.model.vo.Locality;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@Document("event")
@Builder
@NoArgsConstructor
public class Event {
    

    @Id
    String id;
 //   List<Ticket> availableTickets;
    @NonNull
    String nameEvent;
    @NonNull
    String adressEvent;
    @NonNull
    String city;
    @NonNull
    String descriptionEvent;
    @NonNull
    EventType eventType;
    @NonNull
    String[] imageEvent;
    @NonNull
    String imageLocality;
   @NonNull
   LocalDateTime date;
   @NonNull
    List<Locality> locality;
   @NonNull
   Integer capacity;
   @NonNull
    List<Comment> comments;
    @NonNull
    StateEvent stateEvent;
}