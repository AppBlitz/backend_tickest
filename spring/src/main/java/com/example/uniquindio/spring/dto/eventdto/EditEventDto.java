package com.example.uniquindio.spring.dto.eventdto;

import com.example.uniquindio.spring.model.enums.EventType;
import com.example.uniquindio.spring.model.enums.StateEvent;

import com.example.uniquindio.spring.model.vo.Comment;
import com.example.uniquindio.spring.model.vo.items.Locality;
import com.example.uniquindio.spring.model.vo.items.Ticket;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public record EditEventDto(@NonNull String id,
                           @NonNull String nameEvent,
                           @NonNull String adressEvent,
                           @NonNull String city,
                           @NonNull String descriptionEvent,
                           @NonNull EventType eventType,
                           @NonNull String[] imageEvent,
                           @NonNull LocalDate eventDate,
                           @NonNull LocalTime eventTime,
                           @NonNull LocalDate saleStartDate,
                           @NonNull LocalTime saleStartTime,
                           @NonNull List<Locality> locality,
                           @NonNull Integer capacityMax,
                           @NonNull Integer capacity,
                           @NonNull List<Comment> comments,
                           @NonNull StateEvent stateEvent) {
}
