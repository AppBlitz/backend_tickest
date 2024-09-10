package com.example.spring.model.documents;

import org.springframework.data.mongodb.core.mapping.Document;

import com.example.spring.model.enums.State;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@RequiredArgsConstructor
@ToString
@Document("User")
public class User {

  @NonNull
  String fullName;
  @NonNull
  String password;
  @NonNull
  String email;
  @NonNull
  String address;
  @NonNull
  String phoneNumber;
  @NonNull
  State state;
}
