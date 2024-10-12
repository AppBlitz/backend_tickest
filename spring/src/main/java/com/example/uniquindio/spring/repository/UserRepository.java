package com.example.uniquindio.spring.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.uniquindio.spring.model.documents.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndCodeValidatorAndPassword(String email, String codeValidator, String password);

    Optional<User> findByEmailAndPassword(String email, String password);

    boolean existsByEmailAndIdentificationNumber(String email, String identificationNumber);

    boolean existsByIdentificationNumber(String identificationNumber);

    boolean existsBycodeValidator(String codeValidator);

    /* boolean existsdByCodeDiscountRegister(String codeDiscountRegister); */

   // boolean existsByCodeDiscountRegister(String codeDiscountRegister);

}
