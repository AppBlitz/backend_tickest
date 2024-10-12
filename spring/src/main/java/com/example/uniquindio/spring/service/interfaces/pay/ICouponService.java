package com.example.uniquindio.spring.service.interfaces.pay;

import com.example.uniquindio.spring.model.enums.CouponType;
import com.example.uniquindio.spring.model.vo.payment.Coupon;
import com.example.uniquindio.spring.model.vo.payment.CouponAbstract;
import com.example.uniquindio.spring.model.vo.payment.CouponUnique;

import java.time.LocalDate;

public interface ICouponService {

  /**
   * Creates a new coupon with the specified percentage, expiration date, and type.
   *
   * @param name the name of the coupon
   * @param code the code use to using the coupon
   * @param percentage the discount percentage of the coupon
   * @param dateFinish the expiration date of the coupon
   * @param type the type of coupon (as defined in CouponType enum)
   * @return the created Coupon object
   */
  CouponAbstract createCoupon(String name, String code, Float percentage, LocalDate dateFinish, CouponType type, String idUser);

  /**
   * Validates the given coupon based on predefined rules.
   *
   * @param coupon the coupon to be validated
   * @return true if the coupon is valid, false otherwise
   */
  boolean validateCoupon(Coupon coupon);
  /**
   * Validates the given coupon based on predefined rules.
   *
   * @param couponUnique the coupon to be validated
   * @return true if the coupon is valid, false otherwise
   */
  boolean validateCouponUnique(CouponUnique couponUnique);

  /**
   * Searches for a coupon in the coupon collection of the MongoDatabase
   * based on its unique identifier (idCoupon) and marks it as used or finished.
   *
   * @param idCoupon the unique identifier of the coupon
   * @return true if the coupon was successfully marked as finished, false otherwise
   */
  boolean finishCouponUnique(String idCoupon);

  /**
   * Searches for the coupon in the user's coupon list and marks it as used or finished.
   *
   * @param coupon the coupon to be finished for the user
   * @return true if the coupon was successfully marked as finished for the user, false otherwise
   */
  boolean finishCouponIndividual(Coupon coupon);

  /**
   * Sends the given coupon to the user's email address.
   *
   * @param coupon the coupon to be sent
   * @param idUser the id for user to send
   * @return true if the coupon was successfully sent via email, false otherwise
   */
  boolean sendCoupon(Coupon coupon, String idUser);
}
