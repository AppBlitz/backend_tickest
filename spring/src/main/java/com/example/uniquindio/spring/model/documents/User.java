package com.example.uniquindio.spring.model.documents;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.example.uniquindio.spring.model.enums.Rol;
import com.example.uniquindio.spring.model.enums.StateAccount;
import com.example.uniquindio.spring.model.vo.Bill;

@lombok.NoArgsConstructor
@lombok.Data
@lombok.RequiredArgsConstructor
@lombok.ToString
@Document("User")
public class User {

  @lombok.NonNull
  String fullName;
  @lombok.NonNull
  String password;
  @lombok.NonNull
  String email;
  @lombok.NonNull
  String address;
  @lombok.NonNull
  String phoneNumber;
  @lombok.NonNull
  StateAccount state;
  @lombok.NonNull
  List<Bill> bills;
  @lombok.NonNull
  Rol rol;
  @lombok.NonNull
  String identificationNumber;
}
