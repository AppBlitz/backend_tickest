package com.example.uniquindio.spring.dto.userdto;

import lombok.NonNull;

public record LoginUser(@NonNull String email, @NonNull String password) {
}
