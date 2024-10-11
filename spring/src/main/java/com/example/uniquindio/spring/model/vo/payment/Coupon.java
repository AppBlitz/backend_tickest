package com.example.uniquindio.spring.model.vo.payment;

import com.example.uniquindio.spring.model.enums.CouponType;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;


@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@Builder
public class Coupon {

    @EqualsAndHashCode.Include
    @Id
    @NonNull
    private String code;
    @NonNull
    private CouponType type;
    @NonNull
    private String name;
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "1.0", inclusive = true)
    private float discount_percentage;
    @Builder.Default
    private LocalDate date = LocalDate.now();


}
