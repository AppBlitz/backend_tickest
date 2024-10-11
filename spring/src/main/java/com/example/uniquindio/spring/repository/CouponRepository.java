package com.example.uniquindio.spring.repository;

import com.example.uniquindio.spring.model.vo.payment.Coupon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends MongoRepository<Coupon, String> {
}
