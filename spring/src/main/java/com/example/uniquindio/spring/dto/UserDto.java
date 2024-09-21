package com.example.uniquindio.spring.dto;

import java.util.List;

import com.example.uniquindio.spring.model.vo.Bill;

import lombok.NonNull;

public record UserDto(@NonNull String fullName, @NonNull String email, @NonNull String address, @NonNull String password, @NonNull String phoneNumber,
                                                                                                                                                @NonNull String identificationNumber,
                                                                                                                                                @NonNull List<Bill> bills) {
}
