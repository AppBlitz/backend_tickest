package com.example.uniquindio.spring.model.vo.information;

import lombok.NonNull;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("Store")
public class CompanyInformation {

    @NonNull
    private String ID_COMPANY;
    @NonNull
    private String NAME_COMPANY;
    @NonNull
    private String EMAIL_COMPANY;
    @NonNull
    private String PHONE_COMPANY;
    @NonNull
    private String CITY_COMPANY;
}