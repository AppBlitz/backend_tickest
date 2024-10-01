package com.example.uniquindio.spring.dto;


import com.example.uniquindio.spring.model.enums.StateAccount;
import com.example.uniquindio.spring.model.vo.Invoice;

import lombok.NonNull;

import java.util.List;

public record UserInformationDTO(@NonNull String fullName, @NonNull String email, @NonNull String address,
                                 @NonNull String phoneNumber, @NonNull String ID) {
}
