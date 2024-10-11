package com.example.uniquindio.spring.service.imp.pay;

import java.time.LocalDate;
import java.util.Random;

import com.example.uniquindio.spring.model.enums.CouponType;
import com.example.uniquindio.spring.model.vo.payment.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uniquindio.spring.repository.UserRepository;
import com.example.uniquindio.spring.service.interfaces.pay.ICouponService;

@Service
public class CouponService implements ICouponService {


    @Override
    public Coupon createCoupon(Double percentage, LocalDate dateFinish, CouponType type) {
        return null;
    }

    @Override
    public boolean validateCoupon(Coupon coupon) {
        return false;
    }

    @Override
    public boolean finishCouponUnique(String idCoupon) {
        return false;
    }

    @Override
    public boolean finishCouponIndividual(Coupon coupon) {
        return false;
    }

    @Override
    public boolean sendCoupon(Coupon coupon) {
        return false;
    }
}
