package com.example.uniquindio.spring.dto.user;

import lombok.NonNull;

public record LoginUser(@NonNull String email, @NonNull String password) {
}
