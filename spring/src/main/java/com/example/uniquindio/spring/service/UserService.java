package com.example.uniquindio.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.uniquindio.spring.model.documents.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uniquindio.spring.dto.UserDto;
import com.example.uniquindio.spring.dto.emaildto.EmailDto;
import com.example.uniquindio.spring.dto.user.LoginUser;
import com.example.uniquindio.spring.dto.user.UpdateUserDtoRegister;
import com.example.uniquindio.spring.exception.EmailInvalidException;
import com.example.uniquindio.spring.exception.PasswordInvalidException;
import com.example.uniquindio.spring.exception.UserException;
import com.example.uniquindio.spring.model.documents.User;
import com.example.uniquindio.spring.model.enums.Rol;
import com.example.uniquindio.spring.model.enums.StateAccount;
import com.example.uniquindio.spring.repository.UserRepository;
import com.example.uniquindio.spring.service.interfaces.IUserService;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmailService emailService;

    @Autowired
    CouponService couponService;

    @Override
    public Optional<User> findByEmail(String email) throws EmailInvalidException {
        return userRepository.findByEmail(email);
    }

    @Override
    public User saveUser(UserDto userdto) throws Exception {
        // Create an empty user object
        User user = new User();

        // Set the user data
        user.setFullName(userdto.fullName());
        user.setPassword(userdto.password());
        user.setEmail(userdto.email());
        user.setAddress(userdto.address());
        user.setPhoneNumber(userdto.phoneNumber());

        // Set the account state to idle
        user.setState(StateAccount.IDLE);

        // Initialize invoices list
        List<String> invoices = new ArrayList<>();
        user.setInvoices(invoices);

        // Set the role as USER
        user.setRol(Rol.USER);

        // Set the identification number and other details
        user.setIdentificationNumber(userdto.identificationNumber());

        // Generate activation code
        String code = couponService.getActivateAccount(20);
        user.setCodeValidator(code);
        user.setCodeDiscountRegister("");

        // Prepare and send the activation email
        EmailDto emaildto = new EmailDto(userdto.email(), "Código para activar la cuenta", "Activación de cuenta", code);
        emailService.sendEmailRegister((emaildto));

        // Save the user object in the repository
        return userRepository.save(user);
    }


    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public boolean validateUser(UserDto userdto) throws UserException {

        return userRepository.existsByEmailAndIdentificationNumber(userdto.email(), userdto.identificationNumber());

    }

    @Override
    public User updateUser(UpdateUserDtoRegister updateUserDtoRegister) throws Exception {

        Optional<User> updateUser = userRepository.findByEmailAndCodeValidatorAndPassword(updateUserDtoRegister.email(),
                updateUserDtoRegister.codeValidator(), updateUserDtoRegister.password());
        if (updateUser.isEmpty()) {
            throw new RuntimeException(" User not found");
        } else {
            String code = couponService.getCouponDescountRegiserFisrt(20);
            User user = updateUser.get();
            user.setState((StateAccount.ASSET));
            user.setCodeDiscountRegister(code);
            user.setCodeValidator("IDLE");
            userRepository.save(user);
            EmailDto emaildto = new EmailDto(user.getEmail(),
                    "Código de descuento \n el código solo es aplicable para un compra \n descuento del 15 % \n",
                    "Código de descuento",
                    code);
            emailService.sendDescountCode(emaildto);
            return user;
        }

    }

    @Override
    public Optional<User> findByEmailAndPassword(LoginUser loginUser)
            throws EmailInvalidException, PasswordInvalidException {
        return userRepository.findByEmailAndPassword((loginUser.email()), loginUser.password());
    }
}
