package com.example.uniquindio.spring.service.imp.pay;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uniquindio.spring.repository.UserRepository;
import com.example.uniquindio.spring.service.interfaces.pay.ICouponService;

@Service
public class CouponService implements ICouponService {
  private final String code = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
  private final Random random = new Random();

  @Autowired
  UserRepository userRepository;

  @Override
  public String getActivateAccount(int number) {
    return validateActivateAccount("", number);
  }

  @Override
  public String getCouponRecorverPassword(int number) {
    return generateCode((number));
  }



  private String generateCode(int number) {
    String centinela = "";
    while (number > 0) {
      centinela += code.charAt(random.nextInt(code.length()));
      number = number - 1;
    }
    return centinela;
  }

  private String validateActivateAccount(String code, int number) {
    boolean auxiliar = true;
    while (auxiliar != false) {
      code = generateCode(number);
      auxiliar = userRepository.existsBycodeValidator(code);
    }
    return code;
  }


}
