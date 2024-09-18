package com.example.uniquindio.spring.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.uniquindio.spring.model.documents.User;
import com.example.uniquindio.spring.service.UserService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
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
  // @GetMapping("")
  @RequestMapping(value = "/user/{email}", method = RequestMethod.GET)
  public ResponseEntity<Optional<User>> findByEmail(@PathVariable("email") String email) {
    Optional<User> user = userService.findByEmail(email);
    return ResponseEntity.status(200).body(user);
  }

  /**
   * TODO: Method for obtaining all users
   * 
   * @return
   */
  @RequestMapping(value = "/user/all", method = RequestMethod.GET)
  public ResponseEntity<List<User>> getAll() {
    List<User> users = userService.getAllUser();
    return ResponseEntity.status(200).body(users);
  }
}
