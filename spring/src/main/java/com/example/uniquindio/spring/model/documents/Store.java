package com.example.uniquindio.spring.model.documents;

import lombok.Singular;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Document("Store")
public class Store {

  @Id
  public static String id = "9876543210";
  public static String NAME_COMPANY = "UniEventos";
  public static String EMAIL_COMPANY = "equiporoblox520@gmail.com";
  public static String PHONE_COMPANY = "1234567890";
  public static String CITY_COMPANY = "Armenia";
}
