package com.example.spring.model.documents;

import java.util.List;

import com.example.spring.model.enums.EventType;
import com.example.spring.model.vo.Comment;

import lombok.NonNull;

public class Event {
  @NonNull
  String nameEvent;
  @NonNull
  EventType eventType;
  @NonNull
  List<Comment> comments;
}
