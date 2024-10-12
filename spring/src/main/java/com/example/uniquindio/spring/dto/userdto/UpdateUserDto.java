package com.example.uniquindio.spring.dto.userdto;

import lombok.NonNull;

public record UpdateUserDto(@NonNull String id, @NonNull String fullName, @NonNull String address,
                            @NonNull String password, @NonNull String phoneNumber,
                            @NonNull String identificationNumber) {
}
