package com.example.uniquindio.spring.model.documents;

import java.util.List;

import com.example.uniquindio.spring.model.vo.items.Coupon;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.example.uniquindio.spring.model.enums.Rol;
import com.example.uniquindio.spring.model.enums.StateAccount;

@lombok.NoArgsConstructor
@lombok.Data
@lombok.RequiredArgsConstructor
@lombok.ToString
@Document("user")
public class User {
    // Login data
    @lombok.NonNull
    String password;
    @lombok.NonNull
    String email;
    @lombok.NonNull
    String codeValidator;

    // Personal user data
    @Id
    String id;
    @lombok.NonNull
    String fullName;
    @lombok.NonNull
    String address;
    @lombok.NonNull
    String phoneNumber;

    // Account state and related data

    StateAccount state;

    Rol rol;
    @lombok.NonNull
    String identificationNumber;

    // Invoices and discount data
    @lombok.NonNull
    List<String> invoices;//List of invoice IDs

    //Coupons data
    @lombok.NonNull
    String codeDiscountRegister;
    List<Coupon> couponsCode;



}
