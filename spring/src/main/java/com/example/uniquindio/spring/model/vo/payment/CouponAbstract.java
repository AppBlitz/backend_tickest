package com.example.uniquindio.spring.model.vo.payment;

import com.example.uniquindio.spring.model.enums.CouponType;
import lombok.*;

@NoArgsConstructor // Generates a no-args constructor
@Getter // Generates getters for all fields
@Setter // Generates setters for all fields // Generates equals and hashCode methods based on all fields
@ToString // Generates a toString method for the class
@AllArgsConstructor // Generates a constructor with all fields
public class CouponAbstract {
    private CouponType type;

}
