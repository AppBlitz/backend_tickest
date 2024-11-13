package com.example.uniquindio.spring.model.documents;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.uniquindio.spring.model.enums.EventType;
import com.example.uniquindio.spring.model.enums.StateEvent;
import com.example.uniquindio.spring.model.vo.Comment;
import com.example.uniquindio.spring.model.vo.items.Locality;

import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@Document("event")
@Builder
@NoArgsConstructor
@ToString

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

    @Null
    private String[] imageEvent;

    @NonNull
    private LocalDate eventDate;

    @NonNull
    private LocalTime eventTime;

    @NonNull
    private LocalDate saleStartDate;

    @NonNull
    private LocalTime saleStartTime;

    @Null
    private List<Locality> locality;

    @NonNull
    private Integer capacityMax;

    @NonNull
    private Integer capacity;

    @Null
    private List<Comment> comments;

    @NonNull
    private StateEvent stateEvent;

    @Null
    private List<String> userList;

}
