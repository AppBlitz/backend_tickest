package com.example.uniquindio.spring.model.vo.information;

import lombok.NonNull;
import org.springframework.data.mongodb.core.mapping.Document;

@lombok.NoArgsConstructor
@lombok.Data
@lombok.RequiredArgsConstructor
@lombok.ToString
@Document("User")
public class UserInformation {

    @NonNull
    String id;
    @lombok.NonNull
    String fullName;
    @lombok.NonNull
    String email;
    @lombok.NonNull
    String address;
    @lombok.NonNull
    String phoneNumber;
}
