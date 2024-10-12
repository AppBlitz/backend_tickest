package com.example.uniquindio.spring.model.vo.payment;

import com.example.uniquindio.spring.model.enums.CouponType;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@NoArgsConstructor // Generates a no-args constructor
@Getter // Generates getters for all fields
@Setter // Generates setters for all fields
@EqualsAndHashCode // Generates equals and hashCode methods based on all fields
@ToString // Generates a toString method for the class
@AllArgsConstructor // Generates a constructor with all fields
@Builder // Allows for a builder pattern to create instances of this class
@Document("couponUnique") // Specifies that this class is a MongoDB document with the collection name "coupon"
public class CouponUnique extends CouponAbstract{

    @EqualsAndHashCode.Include // Indicates this field should be included in equals and hashCode calculations
    @Id // Marks this field as the unique identifier in the MongoDB document
    @NonNull // Indicates that this field cannot be null
    private String code; // Unique code for the coupon
    @NonNull
    private Coupon coupon;

}
