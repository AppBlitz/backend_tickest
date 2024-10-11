package com.example.uniquindio.spring.Controller.interfaces.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.uniquindio.spring.dto.userdto.UserDto;
import com.example.uniquindio.spring.dto.userdto.UpdateUserDtoRegister;
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
