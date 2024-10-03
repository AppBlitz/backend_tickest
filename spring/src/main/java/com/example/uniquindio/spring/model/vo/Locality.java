package com.example.uniquindio.spring.model.vo;

import lombok.NonNull;

@lombok.NoArgsConstructor
@lombok.Data
@lombok.RequiredArgsConstructor
@lombok.ToString

public class Locality {

    @NonNull
    String nombre;

    @NonNull
    int capacity;

    @NonNull
    double price;


}
