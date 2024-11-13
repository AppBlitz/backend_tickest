package com.example.uniquindio.spring.dto.eventdto;

import com.example.uniquindio.spring.model.vo.Comment;

import lombok.NonNull;

public record AddCommentEvent(@NonNull String idEvent, @NonNull Comment comment) {
}
