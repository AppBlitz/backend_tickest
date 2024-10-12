package com.example.uniquindio.spring.model.documents;

import com.example.uniquindio.spring.model.vo.payment.Coupon;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.DecimalMin;
import java.util.List;

@NoArgsConstructor // Generates a no-args constructor
@Data // Generates getters, setters, equals, hashCode, and toString methods
@AllArgsConstructor // Generates a constructor with all fields
@ToString // Generates a toString method for the class
@Document("purchaseOrder") // Specifies that this class is a MongoDB document with the collection name "purchaseOrder"
@Builder // Allows for a builder pattern to create instances of this class
public class PurchaseOrder {

    @Id // Marks this field as the unique identifier in the MongoDB document
    @NonNull // Indicates that this field cannot be null
    String purchaseOrderNumber; // Unique identifier for the purchase order

    @NonNull // Indicates that this field cannot be null
    ShoppingCart shoppingCart; // Shopping cart associated with this purchase order

    @NonNull // Indicates that this field cannot be null
    String idGateway; //identifier for the Payment gateway

    @DecimalMin(value = "0.0", inclusive = true) // Ensures that the debit value is at least 0.0
    @Builder.Default // Sets a default value for this field when using the builder
    Double debit = 0.0; // The debit amount for the purchase order, defaults to 0.0

    @DecimalMin(value = "0.0", inclusive = true) // Ensures that the credit value is at least 0.0
    @Builder.Default // Sets a default value for this field when using the builder
    Double credit = 0.0; // The credit amount for the purchase order, defaults to 0.0

    @DecimalMin(value = "0.0", inclusive = true) // Ensures that the total value is at least 0.0
    @Builder.Default // Sets a default value for this field when using the builder
    Double total = 0.0; // The total amount for the purchase order, defaults to 0.0

    @NonNull // Indicates that this field cannot be null
    List<Coupon> couponList; // List of coupons associated with this purchase order
}
