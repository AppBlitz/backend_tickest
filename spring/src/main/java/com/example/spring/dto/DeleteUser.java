package com.example.spring.dto;

import lombok.NonNull;

public record DeleteUser(@NonNull String email, @NonNull String password) {
}
