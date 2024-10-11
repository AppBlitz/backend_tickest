package com.example.uniquindio.spring.model.documents;

import com.example.uniquindio.spring.model.vo.information.CompanyInformation;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@NoArgsConstructor // Generates a no-args constructor
@Data // Generates getters, setters, equals, hashCode, and toString methods
@AllArgsConstructor // Generates a constructor with all fields
@ToString // Generates a toString method for the class
@Document("invoice") // Specifies that this class is a MongoDB document with the collection name "invoice"
@Builder // Allows for a builder pattern to create instances of this class
public class Invoice {

  // Company information
  @NonNull // Indicates that this field cannot be null
  CompanyInformation companyInformation; // Information about the company

  @NonNull // Indicates that this field cannot be null
  PurchaseOrder purchaseOrder; // Purchase order associated with this invoice

  // Invoice information
  @Builder.Default // Sets a default value for this field when using the builder
  LocalDate date = LocalDate.now(); // The date of the invoice, defaults to the current date

  @Id // Marks this field as the unique identifier in the MongoDB document
  long invoiceNumber; // Unique number identifying the invoice

  @NonNull // Indicates that this field cannot be null
  String PaymentMethod; // The payment method used for the invoice

  // QR Code
  byte[] QR; // Byte array representing the QR code associated with the invoice
}
