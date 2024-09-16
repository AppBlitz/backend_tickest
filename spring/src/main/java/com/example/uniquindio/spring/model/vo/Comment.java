package com.example.uniquindio.spring.model.vo;

import java.time.LocalDateTime;

import com.example.uniquindio.spring.model.documents.User;

import lombok.NonNull;

public class Comment {

  @NonNull
  User user;

  @NonNull
  LocalDateTime localData;

  @NonNull
  String comment;

}
