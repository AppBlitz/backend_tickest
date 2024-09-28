package com.example.uniquindio.spring.model.documents;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.uniquindio.spring.model.vo.Items;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.ToString
@lombok.RequiredArgsConstructor
@Document("ShoppingCart")
public class ShoppingCart {

    @Id
    String id;
    @lombok.NonNull
    String nameUser;

    @lombok.NonNull
    String email;

    @lombok.NonNull
    LocalDate localData;

    @lombok.NonNull
    List<Items> items;

    @lombok.NonNull
    String phoneNumber;

    @lombok.NonNull
    String identificationNumber;

}
