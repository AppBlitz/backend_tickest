package com.example.uniquindio.spring.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.uniquindio.spring.dto.UserDto;
import com.example.uniquindio.spring.dto.user.UpdateUserDtoRegister;
import com.example.uniquindio.spring.model.documents.User;

public interface AccountController {

  /**
   * @param userdto
   * @return
   * @throws Exception
   */
  public ResponseEntity<User> saveUser(@RequestBody UserDto userdto) throws Exception;

  /**
   * @param updateUserDtoRegister
   * @return
   * @throws Exception
   */
  public ResponseEntity<User> updateUserRegister(@RequestBody UpdateUserDtoRegister updateUserDtoRegister)
      throws Exception;
}
