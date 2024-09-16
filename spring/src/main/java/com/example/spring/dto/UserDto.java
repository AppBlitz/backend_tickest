package com.example.spring.dto;

import java.util.List;

import com.example.spring.model.enums.StateAccount;
import com.example.spring.model.vo.Bill;

import lombok.NonNull;

public record UserDto(@NonNull String fullName, @NonNull String email, @NonNull String address,
                                                                @NonNull String password, @NonNull String phoneNumber,
                                                                @NonNull StateAccount state, List<Bill> bill) {
}
