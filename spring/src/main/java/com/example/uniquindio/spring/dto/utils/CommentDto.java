package com.example.uniquindio.spring.dto.utils;

import lombok.NonNull;

public record CommentDto(@NonNull String IdUser, @NonNull String text,@NonNull String idEvent) {
}
