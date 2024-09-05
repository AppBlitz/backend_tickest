
package com.example.spring.model.documents;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@RequiredArgsConstructor
@ToString
public class User {
  @NonNull
  String fullName;
  /*
   * @NonNull
   * String Id;
   */
  @NonNull
  String password;
  @NonNull
  String email;
  @NonNull
  String addres;
  @NonNull
  String phoneNumber;
}
