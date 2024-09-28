package com.example.uniquindio.spring.model.documents;

import java.awt.*;
import java.time.LocalDate;
import java.util.List;

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

@Document
@Getter
@Setter
@AllArgsConstructor

public class Event {

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
    LocalDate date;
    @NonNull
    List<Locality> locality;
    @NonNull
    List<Comment> comments;
    @NonNull
    StateEvent stateEvent;
}
