package com.example.uniquindio.spring.Controller.interfaces.user;

import java.util.List;
import java.util.Optional;

import com.example.uniquindio.spring.dto.userdto.UserDto;
import com.example.uniquindio.spring.dto.utils.CommentDto;
import com.example.uniquindio.spring.dto.utils.JWTUtilsdto.MensajeDto;
import com.example.uniquindio.spring.dto.utils.JWTUtilsdto.TokenDto;
import com.example.uniquindio.spring.exception.user.UserException;
import com.example.uniquindio.spring.model.vo.Comment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.uniquindio.spring.dto.userdto.LoginUser;
import com.example.uniquindio.spring.model.documents.User;

public interface UserController {
    public ResponseEntity<MensajeDto<String>> saveUser(@RequestBody UserDto userDto) throws Exception;
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
    public ResponseEntity<MensajeDto<TokenDto>> login(@RequestBody LoginUser loginUser) throws Exception;

    public ResponseEntity<Comment> postComment(@RequestBody CommentDto comment) throws Exception;
}
