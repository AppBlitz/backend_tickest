package com.example.uniquindio.spring.dto;

import lombok.NonNull;

public record DeleteUser(@NonNull String email, @NonNull String password) {
}