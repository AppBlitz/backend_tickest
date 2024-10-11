
package com.example.uniquindio.spring.dto.userdto;

import lombok.NonNull;

public record UserDto(@NonNull String fullName, @NonNull String email, @NonNull String address,
                      @NonNull String password, @NonNull String phoneNumber,
                      @NonNull String identificationNumber) {
}