package com.example.spring.model.vo;

import java.time.LocalDateTime;
import com.example.spring.model.documents.User;

import lombok.NonNull;

public class Comment {

  @NonNull
  User user;

  @NonNull
  LocalDateTime localData;

  @NonNull
  String comment;

}
