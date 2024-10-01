package com.example.uniquindio.spring.model.documents;
import com.example.uniquindio.spring.model.enums.CouponType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@Document("coupons")

public class Coupon {
    @EqualsAndHashCode.Include
    @Id
    private String code;
    private CouponType type;
    private String name;
    private float discount_percentage;
    private LocalDate date;

    @Builder
    public Coupon(CouponType type){
        this.type = type;
    }

}
