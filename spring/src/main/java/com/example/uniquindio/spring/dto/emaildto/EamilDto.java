package com.example.uniquindio.spring.dto.emaildto;

import lombok.NonNull;

public record EamilDto(@NonNull String email,@NonNull String message, @NonNull String object) {
}
