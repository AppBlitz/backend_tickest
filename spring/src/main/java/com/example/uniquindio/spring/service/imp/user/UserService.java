package com.example.uniquindio.spring.service.imp.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.uniquindio.spring.dto.utils.CommentDto;
import com.example.uniquindio.spring.model.documents.Event;
import com.example.uniquindio.spring.model.enums.CouponType;
import com.example.uniquindio.spring.model.vo.Comment;
import com.example.uniquindio.spring.model.vo.information.UserInformation;
import com.example.uniquindio.spring.model.vo.payment.Coupon;
import com.example.uniquindio.spring.service.imp.email.EmailService;
import com.example.uniquindio.spring.service.imp.event.EventService;
import com.example.uniquindio.spring.service.imp.pay.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uniquindio.spring.dto.userdto.UserDto;
import com.example.uniquindio.spring.dto.emaildto.EmailDTO;
import com.example.uniquindio.spring.dto.userdto.LoginUser;
import com.example.uniquindio.spring.dto.userdto.UpdateUserDtoRegister;
import com.example.uniquindio.spring.exception.email.EmailInvalidException;
import com.example.uniquindio.spring.exception.user.PasswordInvalidException;
import com.example.uniquindio.spring.exception.user.UserException;
import com.example.uniquindio.spring.model.documents.User;
import com.example.uniquindio.spring.model.enums.Rol;
import com.example.uniquindio.spring.model.enums.StateAccount;
import com.example.uniquindio.spring.repository.UserRepository;
import com.example.uniquindio.spring.service.interfaces.user.IUserService;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmailService emailService;

    @Autowired
    CouponService couponService;
    @Autowired
    EventService eventService;

    @Override
    public Optional<User> findByEmail(String email) throws EmailInvalidException {
        return userRepository.findByEmail(email);
    }

    @Override
    public User saveUser(UserDto userdto) throws Exception {
        if (!userRepository.existsById(userdto.identificationNumber())) {
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
            Coupon coupon = new Coupon();
            coupon.setCode("BIENBENIDA");
            coupon.setType(CouponType.UNIQUE_CODE);
            coupon.setDiscount_percentage(0.1F);
            coupon.setName("Bienvenida");
            user.getCouponsCode().add(coupon);

            // Prepare and send the activation email
            EmailDTO emaildto = new EmailDTO(userdto.email(), "Código para activar la cuenta", "Activación de cuenta");
            //emailService.sendEmailRegister((emaildto));

            // Save the user object in the repository
            return userRepository.save(user);

        }
        return null;
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
                updateUserDtoRegister.couponList().toString(), updateUserDtoRegister.password());
        if (updateUser.isEmpty()) {
            throw new RuntimeException(" User not found");
        } else {
            String code = couponService.getCouponDescountRegiserFisrt(20);
            User user = updateUser.get();
            user.setState((StateAccount.ASSET));
            user.setCouponsCode(updateUserDtoRegister.couponList());
            user.setCodeValidator("IDLE");
            userRepository.save(user);
            /**EmailDTO emaildto = new EmailDTO(user.getEmail(),
                    "Código de descuento \n el código solo es aplicable para un compra \n descuento del 15 % \n",
                    "Código de descuento",
                    code);
            emailService.sendDescountCode(emaildto);
            return user;**/
        }
        return null;
    }

    @Override
    public Optional<User> findByEmailAndPassword(LoginUser loginUser)
            throws EmailInvalidException, PasswordInvalidException {
        return userRepository.findByEmailAndPassword((loginUser.email()), loginUser.password());
    }

    public UserInformation getInformation(User user) {
        UserInformation userInformation = new UserInformation();
        userInformation.setFullName(user.getFullName());
        userInformation.setAddress(user.getAddress());
        userInformation.setEmail(user.getEmail());
        userInformation.setId(user.getIdentificationNumber());
        userInformation.setPhoneNumber(user.getPhoneNumber());
        return userInformation;
    }

    public Comment postComment(CommentDto commentdto)throws UserException {
        Comment comment = new Comment();
        Optional<User> u=userRepository.findById(commentdto.IdUser());
        comment.setUser(u.get());
        comment.setComment(commentdto.text());

        Event e = eventService.getEventById(commentdto.idEvent());
        e.getComments().add(comment);

        return comment;
    }
}
