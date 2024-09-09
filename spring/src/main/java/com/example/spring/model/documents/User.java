package com.example.spring.model.documents;

import com.example.spring.model.enums.State;

@lombok.NoArgsConstructor
@lombok.Data
@lombok.RequiredArgsConstructor
@lombok.ToString
public class User {

  @lombok.NonNull
  String fullName;
  @lombok.NonNull
  String password;
  @lombok.NonNull
  String email;
  @lombok.NonNull
  String addres;
  @lombok.NonNull
  String phoneNumber;
  @lombok.NonNull
  State state;
}
