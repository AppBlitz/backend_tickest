package com.example.uniquindio.spring.model.documents;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.DecimalMin;

@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString
@Document("purchaseOrder")
@Builder
public class PurchaseOrder {

    @Id
    @NonNull
    String purchaseOrderNumber;

    @NonNull
    ShoppingCart shoppingCart;

    @DecimalMin(value = "0.0", inclusive = true)
    @Builder.Default
    Double debit = 0.0;

    @DecimalMin(value = "0.0", inclusive = true)
    @Builder.Default
    Double credit = 0.0;

    @DecimalMin(value = "0.0", inclusive = true)
    @Builder.Default
    Double total = 0.0;


}
