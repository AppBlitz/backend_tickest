package com.example.uniquindio.spring.service.interfaces.user;

import java.util.List;
import java.util.Optional;

import com.example.uniquindio.spring.dto.userdto.*;
import com.example.uniquindio.spring.dto.utils.CommentDto;
import com.example.uniquindio.spring.exception.email.EmailInvalidException;
import com.example.uniquindio.spring.exception.user.PasswordInvalidException;
import com.example.uniquindio.spring.exception.user.UserException;
import com.example.uniquindio.spring.model.documents.User;
import com.example.uniquindio.spring.model.vo.Comment;
import com.example.uniquindio.spring.model.vo.information.UserInformation;

public interface IUserService {

    public User updateUser(UpdateUserDtoRegister updateUserDtoRegister) throws Exception;

    public Optional<User> findByEmailAndPassword(LoginUser loginUser)
            throws EmailInvalidException, PasswordInvalidException;

    /**
     * Method to save User in database
     *
     * @param userdto
     * @return Object User saved
     */
    public User saveUser(UserDto userdto) throws Exception;

    /**
     * Search for all Users
     *
     * @return List of all Users registred
     */
    public List<User> getAllUser();


    public void editUser(UpdateUserDto user);

    /**
     *
     * @param userdto
     * @throws Exception
     */
    public void deleteUser(UpdateUserDto userdto) throws Exception;
    /**
     * Search for the user by email
     *
     * @param email
     * @return A Optional null if not exists, Optinal User if exists
     */


    public Optional<User> findByEmail(String email) throws EmailInvalidException;

    /**
     * Method to check if a user exists
     *
     * @param userdto
     * @return true if the user exists and false if it does not exist
     */
    public boolean validateUser(UserDto userdto) throws UserException;

    /**
     * get infromation of user
     *
     * @param user
     * @return
     */
    UserInformation getInformation(User user);

    /**
     * post comment in a event
     *
     * @param commentdto
     * @return
     * @throws UserException
     */
    public Comment postComment(CommentDto commentdto)throws UserException;
}
