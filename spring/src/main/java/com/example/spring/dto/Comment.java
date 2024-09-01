package com.example.spring.dto;

import lombok.NonNull;

public record Comment(@NonNull String nameUser, @NonNull String text, @NonNull String date) {
}
