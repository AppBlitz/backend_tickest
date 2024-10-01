package com.example.uniquindio.spring.model.documents;

import java.util.List;

import lombok.NonNull;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.uniquindio.spring.model.enums.StateAccount;
import com.example.uniquindio.spring.model.vo.Invoice;

@lombok.NoArgsConstructor
@lombok.Data
@lombok.RequiredArgsConstructor
@lombok.ToString
@Document("User")
public class User {

  @NonNull
  String id;
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
  List<Invoice> invoice;
}
