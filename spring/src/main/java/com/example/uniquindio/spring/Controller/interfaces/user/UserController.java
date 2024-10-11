package com.example.uniquindio.spring.Controller.interfaces.user;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.uniquindio.spring.dto.userdto.LoginUser;
import com.example.uniquindio.spring.model.documents.User;

public interface UserController {
    /**
     * @param email
     * @return
     * @throws Exception
     */
    public ResponseEntity<Optional<User>> findByEmail(@PathVariable String email) throws Exception;

    /**
     * @return
     * @throws Exception
     */
    public ResponseEntity<List<User>> getAll() throws Exception;

    /**
     * @param loginUser
     * @return
     * @throws Exception
     */
    public ResponseEntity<Optional<User>> login(@RequestBody LoginUser loginUser) throws Exception;
}
