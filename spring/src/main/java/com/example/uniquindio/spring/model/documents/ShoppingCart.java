package com.example.uniquindio.spring.model.documents;

import java.time.LocalDate;
import java.util.List;
import com.example.uniquindio.spring.model.vo.information.UserInformation;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.example.uniquindio.spring.model.vo.items.Item;

@Data // Generates getters, setters, equals, hashCode, and toString methods
@NoArgsConstructor // Generates a no-args constructor
@ToString // Generates a toString method for the class
@AllArgsConstructor // Generates a constructor with all fields
@Document("shoppingCart") // Specifies that this class is a MongoDB document with the collection name "shoppingCart"
@Builder // Allows for a builder pattern to create instances of this class
public class ShoppingCart {

    @Id // Marks this field as the unique identifier in the MongoDB document
    String id; // Unique identifier for the shopping cart

    // User information
    @NonNull // Indicates that this field cannot be null
            UserInformation userInformation; // Information about the user associated with the shopping cart

    @NonNull // Indicates that this field cannot be null
    List<Item> items; // List of items in the shopping cart
}
