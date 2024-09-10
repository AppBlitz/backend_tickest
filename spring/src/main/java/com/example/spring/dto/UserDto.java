package com.example.spring.dto;

import com.example.spring.model.enums.State;

import lombok.NonNull;

public record UserDto(@NonNull String fullName, @NonNull String email, @NonNull String address,
                                @NonNull String password, @NonNull String phoneNumber, @NonNull State state) {
}
