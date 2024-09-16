package com.example.uniquindio.spring.model.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("Store")
public class Store {

  @Id
  String id;

}
