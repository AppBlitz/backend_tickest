package com.example.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.dto.DeleteUser;
import com.example.spring.dto.UserDto;
import com.example.spring.model.documents.User;
import com.example.spring.repository.UserRepository;

@Service
public class UserService {
  @Autowired
  UserRepository userRepository;

  /**
   * Method is responsible for capturing a user by email
   * 
   * @param email
   * @return User
   *
   */
  public Optional<User> getUser(String email) {

    return userRepository.findByEmail(email);

  }

  public void deleteUser(DeleteUser deleteUser) {

  }

  /**
   * Method for create
   * 
   * @param userdto
   * @return User created
   */
  public User saveUser(UserDto userdto) {

    User user = new User(userdto.fullName(), userdto.password(), userdto.email(), userdto.addres(),
        userdto.phoneNUmber());
    return userRepository.save(user);

  }

}
