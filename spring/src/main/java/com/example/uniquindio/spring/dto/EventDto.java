package com.example.uniquindio.spring.dto;

import com.example.uniquindio.spring.model.enums.EventType;
import com.example.uniquindio.spring.model.enums.StateEvent;
import com.example.uniquindio.spring.model.vo.Comment;
import com.example.uniquindio.spring.model.vo.items.Locality;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.List;

public record EventDto(
                       @NonNull
                       String nameEvent,
                       @NonNull
                       String adressEvent,
                       @NonNull
                       String city,
                       @NonNull
                       String descriptionEvent,
                       @NonNull
                       EventType eventType,
                       @NonNull
                       String[] imageEvent,
                       @NonNull
                       String imageLocality,
                       @NonNull
                       LocalDate date,
                       @NonNull
                       List<Locality> locality,
                       @NonNull
                       List<Comment> comments,
                       @NonNull
                       StateEvent stateEvent,
                       @NonNull
                       Integer capacity) {

}
