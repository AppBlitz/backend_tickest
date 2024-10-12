package com.example.uniquindio.spring.model.vo.payment;

import com.example.uniquindio.spring.model.enums.CouponType;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Builder
@NoArgsConstructor // Generates a no-args constructor
@Getter // Generates getters for all fields
@Setter // Generates setters for all fields
@EqualsAndHashCode // Generates equals and hashCode methods based on all fields
@ToString // Generates a toString method for the class
@AllArgsConstructor // Generates a constructor with all fields
public class Coupon extends CouponAbstract {

    @EqualsAndHashCode.Include // Indicates this field should be included in equals and hashCode calculations
    @Id // Marks this field as the unique identifier in the MongoDB document
    @NonNull // Indicates that this field cannot be null
    private String code; // Unique code for the coupon

    @NonNull // Indicates that this field cannot be null
    @Field("couponType")
    private CouponType type; // The type of the coupon (defined in the CouponType enum)

    @NonNull // Indicates that this field cannot be null
    private String name; // The name of the coupon

    @DecimalMin(value = "0.0", inclusive = true) // Ensures the discount percentage is at least 0.0
    @DecimalMax(value = "1.0", inclusive = true) // Ensures the discount percentage does not exceed 1.0 (100%)
    private float discount_percentage; // The discount percentage of the coupon

    @Builder.Default // Sets a default value for this field when using the builder
    private LocalDate date = LocalDate.now(); // The date of coupon creation, defaults to the current date

    @Builder.Default // Sets a default value for this field when using the builder
    private boolean active = true; // Indicates whether the coupon is active, defaults to true
}
