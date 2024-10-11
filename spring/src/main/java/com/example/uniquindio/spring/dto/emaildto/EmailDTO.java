package com.example.uniquindio.spring.dto.emaildto;

import lombok.NonNull;

public record EmailDTO(

        @NonNull String email,
        @NonNull String message,
        @NonNull String subject

) {
}
