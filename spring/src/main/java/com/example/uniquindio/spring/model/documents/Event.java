package com.example.uniquindio.spring.model.documents;

import java.util.List;

import com.example.uniquindio.spring.model.enums.EventType;
import com.example.uniquindio.spring.model.enums.StateEvent;
import com.example.uniquindio.spring.model.vo.Comment;

import lombok.NonNull;

public class Event {

    @NonNull
    String nameEvent;
    @NonNull
    EventType eventType;
    @NonNull
    List<Comment> comments;
    @NonNull
    StateEvent stateEvent;
}