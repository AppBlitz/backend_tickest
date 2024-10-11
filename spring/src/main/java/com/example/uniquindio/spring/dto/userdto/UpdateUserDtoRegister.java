package com.example.uniquindio.spring.dto.userdto;

import com.example.uniquindio.spring.model.vo.payment.Coupon;
import lombok.NonNull;

import java.util.List;

public record UpdateUserDtoRegister(
        @NonNull String email,
        @NonNull List<Coupon> couponList,
        @NonNull String password) {
}
