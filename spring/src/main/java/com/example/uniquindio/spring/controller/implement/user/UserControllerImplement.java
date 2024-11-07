package com.example.uniquindio.spring.Controller.implement.user;

import java.util.List;
import java.util.Optional;

import com.example.uniquindio.spring.Controller.interfaces.user.UserController;
import com.example.uniquindio.spring.dto.userdto.LoginUser;
import com.example.uniquindio.spring.dto.userdto.UpdateUserDto;
import com.example.uniquindio.spring.dto.userdto.UserDto;
import com.example.uniquindio.spring.dto.userdto.UserInformationDTO;
import com.example.uniquindio.spring.dto.utils.CommentDto;
import com.example.uniquindio.spring.dto.utils.JWTUtilsdto.MensajeDto;
import com.example.uniquindio.spring.dto.utils.JWTUtilsdto.TokenDto;
import com.example.uniquindio.spring.exception.user.UserException;
import com.example.uniquindio.spring.model.documents.User;
import com.example.uniquindio.spring.model.vo.Comment;
import com.example.uniquindio.spring.service.imp.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/users")
public class UserControllerImplement implements UserController {

    @Autowired
    UserService userService;

    @Override
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public ResponseEntity<MensajeDto<String>> saveUser(@RequestBody UserDto userdto) throws Exception {
        userService.saveUser(userdto);
        return ResponseEntity.ok(new MensajeDto<>(false,"el usuario fue agregado con exito"));
    }

    @Override
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity<MensajeDto<TokenDto>> login(@RequestBody() LoginUser loginUser) throws Exception {
        TokenDto token = userService.verifyLogin((loginUser));
        return ResponseEntity.ok(new MensajeDto<>(false,token));

    }

    @Override
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public ResponseEntity<MensajeDto<String>> edituser(@RequestBody UpdateUserDto userDto) throws Exception {
        userService.editUser(userDto);
        return ResponseEntity.ok(new MensajeDto<>(false,"usuario editado con exito"));
    }

    @Override
    @RequestMapping(value = "/user/{email}", method = RequestMethod.GET)
    public ResponseEntity<Optional<User>> findByEmail(@PathVariable("email") String email)
            throws Exception {
        Optional<User> user = userService.findByEmail(email);
        return ResponseEntity.status(200).body(user);
    }

    @Override
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAll() throws Exception {
        List<User> users = userService.getAllUser();
        return ResponseEntity.status(200).body(users);
    }

    @Override
    @RequestMapping(value = "/postComment", method = RequestMethod.POST)
    public ResponseEntity<Comment> postComment(@RequestBody() CommentDto commentdto) throws Exception {
        Comment comment = userService.postComment(commentdto);
        return ResponseEntity.status(200).body(comment);
    }



}
