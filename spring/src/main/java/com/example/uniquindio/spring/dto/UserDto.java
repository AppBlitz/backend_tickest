package com.example.uniquindio.spring.dto;

import java.util.List;

import com.example.uniquindio.spring.model.enums.StateAccount;
import com.example.uniquindio.spring.model.vo.Invoice;

import lombok.NonNull;

public record UserDto(@NonNull String fullName, @NonNull String email, @NonNull String address,
        @NonNull String password, @NonNull String phoneNumber,
        @NonNull StateAccount state, List<Invoice> bill) {
}
