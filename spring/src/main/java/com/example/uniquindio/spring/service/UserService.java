package com.example.uniquindio.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uniquindio.spring.dto.UserDto;
import com.example.uniquindio.spring.dto.emaildto.EmailDto;
import com.example.uniquindio.spring.model.documents.User;
import com.example.uniquindio.spring.model.enums.Rol;
import com.example.uniquindio.spring.model.enums.StateAccount;
import com.example.uniquindio.spring.model.vo.Bill;
import com.example.uniquindio.spring.repository.UserRepository;
import com.example.uniquindio.spring.service.interfaces.IUserService;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmailService emailService;

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User saveUser(UserDto userdto) throws Exception {
        List<Bill> bills = new ArrayList<>();
        String code = validateTokens();
        User user = new User(userdto.fullName(), userdto.password(), userdto.email(), userdto.address(),
                userdto.phoneNumber(), StateAccount.IDLE, bills, Rol.USER, userdto.identificationNumber(), code);
        EmailDto emaildto = new EmailDto(userdto.email(), "Código para activar la cuenta", "Activación de cuenta",
                code);
        emailService.sendEmailRegister((emaildto));
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public boolean validateUser(UserDto userdto) {

        return userRepository.existsByEmailAndIdentificationNumber(userdto.email(), userdto.identificationNumber());

    }

    public String validateTokens() {
        String code = "";
        boolean centinela = true;
        while (centinela != false) {
            code = "AQWER3455";
            centinela = userRepository.existsBycodeValidator((code));
        }
        return code;
    }

}
