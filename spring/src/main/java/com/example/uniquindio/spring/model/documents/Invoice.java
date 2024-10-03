package com.example.uniquindio.spring.model.documents;
import com.example.uniquindio.spring.model.vo.information.CompanyInformation;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString
@Document("invoice")
@Builder
public class Invoice {

  //company information
  @NonNull
  CompanyInformation companyInformation;

  @NonNull
  PurchaseOrder purchaseOrder;

  //invoice information
  @Builder.Default
  LocalDate date =LocalDate.now();

  @Id
  @lombok.NonNull
  long invoiceNumber;
  @NonNull
  String PaymentMethod;
  // QR
  @NonNull
  byte[] QR;

  







}
