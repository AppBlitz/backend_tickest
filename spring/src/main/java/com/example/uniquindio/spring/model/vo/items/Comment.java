package com.example.uniquindio.spring.model.vo.items;

import java.time.LocalDateTime;

import lombok.NonNull;

@lombok.NoArgsConstructor
@lombok.Data
@lombok.RequiredArgsConstructor
@lombok.ToString

public class Comment {

    @NonNull
    String user;

    //@NonNull
   // LocalDateTime localData;

    @NonNull
    String comment;

}
