package com.example.uniquindio.spring.repository;

import com.example.uniquindio.spring.model.vo.payment.CouponUnique;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends MongoRepository<CouponUnique, String> {
}
