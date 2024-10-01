package com.example.uniquindio.spring.dto;

import lombok.NonNull;

public record CommentDto(@NonNull String nameUser, @NonNull String text) {
}
