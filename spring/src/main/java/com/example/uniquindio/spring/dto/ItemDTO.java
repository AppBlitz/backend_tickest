package com.example.uniquindio.spring.dto;

import com.example.uniquindio.spring.model.enums.ItemType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@lombok.ToString
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {

    @NonNull
    ItemType type;

    @NonNull
    String description;

    @NonNull
    String cant;

    @NonNull
    Double price;

    @NonNull
    Double total;

}