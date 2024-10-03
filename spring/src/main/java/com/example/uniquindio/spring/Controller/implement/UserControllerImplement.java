package com.example.uniquindio.spring.Controller.implement;

import java.util.List;
import java.util.Optional;

import com.example.uniquindio.spring.Controller.UserController;
import com.example.uniquindio.spring.dto.user.LoginUser;
import com.example.uniquindio.spring.model.documents.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.uniquindio.spring.service.UserService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/users")
public class UserControllerImplement implements UserController {

    @Autowired
    UserService userService;

    @Override
    @RequestMapping(value = "/user/{email}", method = RequestMethod.GET)
    public ResponseEntity<Optional<User>> findByEmail(@PathVariable("email") String email)
            throws Exception {
        Optional<User> user = userService.findByEmail(email);
        return ResponseEntity.status(200).body(user);
    }

    @Override
    @RequestMapping(value = "/user/all", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAll() throws Exception {
        List<User> users = userService.getAllUser();
        return ResponseEntity.status(200).body(users);
    }

    @Override
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public ResponseEntity<Optional<User>> login(@RequestBody() LoginUser loginUser) throws Exception {
        Optional<User> user = userService.findByEmailAndPassword((loginUser));
        return ResponseEntity.status(200).body(user);

    }

}
