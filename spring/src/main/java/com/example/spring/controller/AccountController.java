package com.example.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.dto.UserDto;
import com.example.spring.model.documents.User;
import com.example.spring.service.UserService;

@RestController
@RequestMapping("account")
public class AccountController {

  @Autowired
  UserService userService;

  /**
   * TODO: method create user
   * 
   * @param userdto
   * @return
   */
  @RequestMapping(value = "/account/add", method = RequestMethod.POST)
  public ResponseEntity<User> saveUser(@RequestBody() UserDto userdto) {
    User user = userService.saveUser((userdto));
    return ResponseEntity.status(200).body(user);
  }
}
