package com.example.uniquindio.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uniquindio.spring.dto.UserDto;
import com.example.uniquindio.spring.model.documents.User;
import com.example.uniquindio.spring.model.enums.Rol;
import com.example.uniquindio.spring.model.enums.StateAccount;
import com.example.uniquindio.spring.model.vo.Bill;
import com.example.uniquindio.spring.repository.UserRepository;
import com.example.uniquindio.spring.service.interfaces.IUserService;

@Service
public class UserService implements IUserService {

  @Autowired
  UserRepository userRepository;

  @Override
  public Optional<User> findByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  @Override
  public User saveUser(UserDto userdto) {
    List<Bill> bills = new ArrayList<>();
    User user = new User(userdto.fullName(), userdto.password(), userdto.email(), userdto.address(),
        userdto.phoneNumber(), StateAccount.ASSET, bills, Rol.USER, userdto.identificationNumber());
    return userRepository.save(user);

  }

  @Override
  public List<User> getAllUser() {
    return userRepository.findAll();
  }

  @Override
  public boolean validateUser(UserDto userdto) {

    return userRepository.existsByEmailAndIdentificationNumber(userdto.email(), userdto.identificationNumber());

  }

}
