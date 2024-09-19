package com.example.uniquindio.spring.dto;

import com.example.uniquindio.spring.model.enums.StateAccount;

import lombok.NonNull;

public record UserDto(@NonNull String fullName, @NonNull String email, @NonNull String address,
                                @NonNull String password, @NonNull String phoneNumber, @NonNull StateAccount state) {
}