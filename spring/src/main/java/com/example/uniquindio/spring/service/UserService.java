package com.example.uniquindio.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uniquindio.spring.dto.UserDto;
import com.example.uniquindio.spring.model.documents.User;
import com.example.uniquindio.spring.model.enums.StateAccount;
import com.example.uniquindio.spring.model.vo.Bill;
import com.example.uniquindio.spring.repository.UserRepository;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  /**
   * TODO:Method is responsible for capturing a user by email
   * 
   * @param email
   * @return User
   *
   */
  public Optional<User> findByEmail(String email) {

    return userRepository.findByEmail(email);

  }

  /**
   * TODO: Method user create
   *
   * @param userdto
   * @return User created
   */
  public User saveUser(UserDto userdto) {
    User user = new User(userdto.fullName(), userdto.password(), userdto.email(), userdto.address(),
        userdto.phoneNumber(), StateAccount.ASSET, userdto.bills());
    return userRepository.save(user);

  }

  public List<User> getAllUser() {
    return userRepository.findAll();
  }
}
