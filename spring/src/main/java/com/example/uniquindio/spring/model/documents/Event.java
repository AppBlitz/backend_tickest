package com.example.uniquindio.spring.model.documents;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.example.uniquindio.spring.model.enums.EventType;
import com.example.uniquindio.spring.model.enums.StateEvent;
import com.example.uniquindio.spring.model.vo.Comment;

import lombok.NonNull;

public class Event {

    @Id
    String id;
    @NonNull
    String nameEvent;
    @NonNull
    EventType eventType;
    @NonNull
    List<Comment> comments;
    @NonNull
    StateEvent stateEvent;
}
