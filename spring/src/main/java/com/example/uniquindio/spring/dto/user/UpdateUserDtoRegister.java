package com.example.uniquindio.spring.dto.user;

import lombok.NonNull;

public record UpdateUserDtoRegister(@NonNull String email, @NonNull String codeValidator, @NonNull String password) {
}
