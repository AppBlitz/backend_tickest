package com.example.spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.dto.UserDto;
import com.example.spring.model.documents.User;
import com.example.spring.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  UserService userService;

  /**
   * TODO: Method
   *
   * @param email
   * @return
   */
  @RequestMapping(value = "/user/{email}", method = RequestMethod.GET)
  public ResponseEntity<Optional<User>> findByEmail(@PathVariable("email") String email) {
    Optional<User> user = userService.findByEmail(email);
    return ResponseEntity.status(200).body(user);
  }

  /**
   * TODO: method create user
   * 
   * @param userdto
   * @return
   */
  @PostMapping("/user/add")
  public ResponseEntity<User> saveUser(@RequestBody() UserDto userdto) {
    User user = userService.saveUser((userdto));
    return ResponseEntity.status(200).body(user);
  }

}
