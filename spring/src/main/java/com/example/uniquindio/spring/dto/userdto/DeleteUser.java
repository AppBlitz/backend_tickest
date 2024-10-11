package com.example.uniquindio.spring.dto.userdto;

import lombok.NonNull;

public record DeleteUser(@NonNull String email, @NonNull String password) {
}