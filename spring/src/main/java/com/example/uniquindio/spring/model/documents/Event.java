package com.example.uniquindio.spring.model.documents;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.example.uniquindio.spring.model.vo.items.Ticket;
import lombok.*;
import org.springframework.data.annotation.Id;

import com.example.uniquindio.spring.model.enums.EventType;
import com.example.uniquindio.spring.model.enums.StateEvent;
import com.example.uniquindio.spring.model.vo.items.Comment;

import com.example.uniquindio.spring.model.vo.items.Locality;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@Document("event")
@Builder
@NoArgsConstructor

public class Event {

    @Id
    private String id;


    @NonNull
    private String nameEvent;

    @NonNull
    private String adressEvent;

    @NonNull
    private String city;

    @NonNull
    private String descriptionEvent;

    @NonNull
    private EventType eventType;

    @NonNull
    private String[] imageEvent;

    @NonNull
    private LocalDate eventDate;

    @NonNull
    private LocalTime eventTime;

    @NonNull
    private LocalDate saleStartDate;

    @NonNull
    private LocalTime saleStartTime;

    @NonNull
    private List<Locality> locality;

    @NonNull
    private Integer capacityMax;

    @NonNull
    private Integer capacity;

    @NonNull
    private List<Comment> comments;

    @NonNull
    private StateEvent stateEvent;

}