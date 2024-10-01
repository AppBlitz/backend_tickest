package com.example.uniquindio.spring.model.vo;

import java.util.List;

@lombok.AllArgsConstructor
@lombok.ToString
@lombok.Data
@lombok.NoArgsConstructor
public class Items {

    int QuantityTicketsSold;

    @lombok.NonNull
    String nameLocated;

    @lombok.NonNull
    String town;

    @lombok.NonNull
    List<String> positions;

}