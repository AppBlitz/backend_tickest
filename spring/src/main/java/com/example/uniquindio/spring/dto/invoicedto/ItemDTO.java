package com.example.uniquindio.spring.dto.invoicedto;

import com.example.uniquindio.spring.model.enums.ItemType;
import lombok.NonNull;

public record ItemDTO (

    @NonNull
    ItemType type,

    @NonNull
    String description,

    @NonNull
    String cant,

    @NonNull
    Double price,

    @NonNull
    Double total
){
}