package com.example.uniquindio.spring.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.example.uniquindio.spring.dto.UserDto;
import com.example.uniquindio.spring.model.documents.User;

public interface IUserService {

  public User saveUser(UserDto userdto);

  public List<User> getAllUser();

  public Optional<User> findByEmail(String email);

  public boolean validateUser(UserDto userdto);

}
