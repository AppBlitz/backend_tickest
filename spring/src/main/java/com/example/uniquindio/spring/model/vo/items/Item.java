package com.example.uniquindio.spring.model.vo.items;

import lombok.*;
import org.springframework.data.annotation.Id;
import javax.validation.constraints.Min;

@ToString // Generates a toString method for the class
@Data // Generates getters, setters, equals, hashCode, and toString methods
@AllArgsConstructor // Generates a constructor with all fields
@NoArgsConstructor // Generates a no-args constructor
@EqualsAndHashCode // Generates equals and hashCode methods based on all fields
@Builder // Allows for a builder pattern to create instances of this class
public class Item {

    @Id // Marks this field as the unique identifier in the document
    int id; // Unique identifier for the item

    @Builder.Default // Sets a default value for this field when using the builder
    Ticket ticket = null; // Ticket associated with the item, defaults to null

    @Min(1) // Ensures that the quantity cannot be less than 1
    @Builder.Default // Sets a default value for this field when using the builder
    Integer cant = 1; // The quantity of the item, defaults to 1

}
