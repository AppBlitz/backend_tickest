package com.example.uniquindio.spring.dto;

import com.example.uniquindio.spring.model.enums.EventType;
import com.example.uniquindio.spring.model.enums.StateEvent;
import com.example.uniquindio.spring.model.vo.items.Comment;
import com.example.uniquindio.spring.model.vo.items.Locality;
import lombok.NonNull;

import java.time.LocalDateTime;
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
                       LocalDateTime date,
                       @NonNull
                       List<Locality> locality,

                       int capacity,
                       @NonNull
                       List<Comment> comments,
                       @NonNull
                       StateEvent stateEvent) {

}
