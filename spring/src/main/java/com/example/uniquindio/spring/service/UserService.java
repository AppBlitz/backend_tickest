package com.example.uniquindio.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uniquindio.spring.dto.UserDto;
import com.example.uniquindio.spring.dto.emaildto.EmailDto;
import com.example.uniquindio.spring.dto.user.LoginUser;
import com.example.uniquindio.spring.dto.user.UpdateUserDtoRegister;
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
                userdto.phoneNumber(), StateAccount.IDLE, bills, Rol.USER, userdto.identificationNumber(), code, "");
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

    public User updateUser(UpdateUserDtoRegister updateUserDtoRegister) throws Exception {

        Optional<User> updateUser = userRepository.findByEmail(updateUserDtoRegister.email());
        if (updateUser.isEmpty()) {
            throw new RuntimeException(" User not found");
        } else {
            String code = "JVNSIN8767";
            User user = updateUser.get();
            user.setState((StateAccount.ASSET));
            user.setCodeDiscountRegister((code));
            userRepository.save((user));

            /*
             * EmailDto emaildto = new EmailDto(user.getEmail(),
             * "Código de descuento \n el código solo es aplicable para un compra \n desceunto del 15 % \n"
             * ,
             * "Código de descuento",
             * code);
             * emailService.sendEmailRegister((emaildto))
             */
            return user;
        }

    }

    public Optional<User> findByEmailAndPassword(LoginUser loginUser) {
        return userRepository.findByEmailAndPassword((loginUser.email()), loginUser.password());
    }
}
