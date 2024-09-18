package com.example.uniquindio.spring.dto;

import java.time.LocalDate;
import java.util.List;

import com.example.uniquindio.spring.model.vo.Items;

import lombok.NonNull;

public record ShoppingCartDto(@NonNull String nameUser, @NonNull String email, @NonNull String phoneNumber,
    @NonNull String indentificationNumber, @NonNull List<Items> items, @NonNull LocalDate date) {

}
