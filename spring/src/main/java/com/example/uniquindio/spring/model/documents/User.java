package com.example.uniquindio.spring.model.documents;

import java.util.List;

import com.example.uniquindio.spring.model.vo.payment.Coupon;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.example.uniquindio.spring.model.enums.Rol;
import com.example.uniquindio.spring.model.enums.StateAccount;


@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString
@Document("user")
@Builder
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
    String identificationNumber;
    @lombok.NonNull
    String fullName;
    @lombok.NonNull
    String address;
    @lombok.NonNull
    String phoneNumber;

    // Account state and related data

    StateAccount state;

    Rol rol;
    @NonNull
    String idShoppingCart;
    // Invoices and discount data
    @NonNull
    List<String> invoices;//List of invoice IDs

    //Coupons data
    @NonNull
    List<Coupon> couponsCode;



}
