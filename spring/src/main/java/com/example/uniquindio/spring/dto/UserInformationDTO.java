package com.example.uniquindio.spring.dto;


import lombok.NonNull;

public record UserInformationDTO(@NonNull String fullName, @NonNull String email, @NonNull String address,
                                 @NonNull String phoneNumber, @NonNull String ID) {
}
