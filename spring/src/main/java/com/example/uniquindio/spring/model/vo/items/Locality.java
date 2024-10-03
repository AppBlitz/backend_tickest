package com.example.uniquindio.spring.model.vo.items;

@lombok.NoArgsConstructor
@lombok.Data
@lombok.RequiredArgsConstructor
@lombok.ToString

public class Locality {

    @lombok.NonNull
    String nameLocality;

    double price;

    int capacityMax;


}
