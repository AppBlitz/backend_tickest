package com.example.uniquindio.spring.model.vo;
import lombok.NonNull;

@lombok.NoArgsConstructor
@lombok.Data
@lombok.RequiredArgsConstructor
@lombok.ToString

public class Invoice {

  //company information
  @NonNull
  private CompanyInformation companyInformation;

  //user information
  @NonNull
  private UserInformation userInformation;

  //invoice information
  @NonNull
  private String date;
  @lombok.NonNull
  private long invoiceNumber;

  //details information


  // QR







}
