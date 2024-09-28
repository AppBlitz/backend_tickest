package com.example.uniquindio.spring.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.uniquindio.spring.dto.user.LoginUser;
import com.example.uniquindio.spring.model.documents.User;

public interface UserController {
    public ResponseEntity<Optional<User>> findByEmail(@PathVariable String email) throws Exception;

    public ResponseEntity<List<User>> getAll() throws Exception;

    public ResponseEntity<Optional<User>> login(@RequestBody LoginUser loginUser) throws Exception;
}
