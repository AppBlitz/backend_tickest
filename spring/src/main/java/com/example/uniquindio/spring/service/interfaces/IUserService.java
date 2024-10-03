package com.example.uniquindio.spring.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.example.uniquindio.spring.dto.UserDto;
import com.example.uniquindio.spring.dto.user.LoginUser;
import com.example.uniquindio.spring.dto.user.UpdateUserDtoRegister;
import com.example.uniquindio.spring.exception.EmailInvalidException;
import com.example.uniquindio.spring.exception.PasswordInvalidException;
import com.example.uniquindio.spring.exception.UserException;
import com.example.uniquindio.spring.model.documents.User;

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

}
