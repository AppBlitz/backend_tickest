package com.example.uniquindio.spring.model.vo;

import java.time.LocalDateTime;

import com.example.uniquindio.spring.model.documents.User;

import lombok.NonNull;

@lombok.NoArgsConstructor
@lombok.Data
@lombok.RequiredArgsConstructor
@lombok.ToString

public class Comment {

    @NonNull
    String user;

    @NonNull
    LocalDateTime localData;

    @NonNull
    String comment;

}
