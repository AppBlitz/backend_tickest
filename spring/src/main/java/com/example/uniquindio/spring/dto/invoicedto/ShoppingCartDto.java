package com.example.uniquindio.spring.dto.invoicedto;

import java.util.List;

import com.example.uniquindio.spring.model.vo.items.Item;

import lombok.NonNull;

public record ShoppingCartDto(@NonNull String nameUser, @NonNull String email, @NonNull String phoneNumber,
                              @NonNull String indentificationNumber, @NonNull List<Item> items) {

}
