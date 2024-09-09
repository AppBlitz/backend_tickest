package com.example.spring.dto;

import com.example.spring.model.enums.State;

import lombok.NonNull;

public record UserDto(@NonNull String fullName, @NonNull String id, @NonNull String email, @NonNull String addres,
        @NonNull String password, @NonNull String phoneNumber, @NonNull State state) {
}
