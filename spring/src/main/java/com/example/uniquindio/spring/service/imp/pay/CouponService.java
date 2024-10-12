package com.example.uniquindio.spring.service.imp.pay;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.example.uniquindio.spring.dto.emaildto.EmailDTO;
import com.example.uniquindio.spring.model.documents.User;
import com.example.uniquindio.spring.model.enums.CouponType;
import com.example.uniquindio.spring.model.vo.payment.Coupon;
import com.example.uniquindio.spring.model.vo.payment.CouponAbstract;
import com.example.uniquindio.spring.model.vo.payment.CouponUnique;
import com.example.uniquindio.spring.repository.CouponRepository;
import com.example.uniquindio.spring.service.imp.email.EmailService;
import com.example.uniquindio.spring.service.imp.user.UserService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uniquindio.spring.repository.UserRepository;
import com.example.uniquindio.spring.service.interfaces.pay.ICouponService;

@Service
public class CouponService implements ICouponService {

    // Dependency injection using @Autowired
    @Autowired
    CouponRepository couponRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmailService emailService;

    /**
     * Creates a coupon based on the type. If it's a UNIQUE_CODE type, it creates a unique coupon.
     * Otherwise, it associates it with a specific user.
     *
     * @param name The name of the coupon
     * @param code The coupon code
     * @param percentage The discount percentage of the coupon
     * @param dateFinish The expiration date of the coupon
     * @param type The coupon type (UNIQUE_CODE or regular)
     * @param idUser The ID of the user the coupon is associated with
     * @return Returns the created coupon
     */
    @Override
    public CouponAbstract createCoupon(String name, String code, Float percentage, LocalDate dateFinish, CouponType type, String idUser) {
        Coupon coupon = new Coupon();
        coupon.setName(name);
        coupon.setCode(code);
        coupon.setDiscount_percentage(percentage);
        coupon.setType(type);

        // If the coupon is of type UNIQUE_CODE, create a CouponUnique object
        if (type.equals(CouponType.UNIQUE_CODE)) {
            CouponUnique couponUnique = new CouponUnique();
            couponUnique.setCoupon(coupon);
            couponUnique.setCode(code);
            CouponAbstract couponAbstract = couponUnique;
            couponAbstract.setType(type);
            couponRepository.save(couponUnique); // Save to the coupon repository
            return couponAbstract;
        } else {
            // If it's a regular coupon, associate it with the user
            CouponAbstract couponAbstract = coupon;
            couponAbstract.setType(type);
            User user = userRepository.findById(idUser).get();
            user.getCouponsCode().add(coupon); // Add coupon to user's coupon list
            userRepository.save(user); // Update user in the repository
            return couponAbstract;
        }
    }

    /**
     * Validates if the coupon is still valid by checking if the current date is before the expiration date.
     *
     * @param coupon The coupon to be validated
     * @return True if the coupon is still valid, false otherwise
     */
    @Override
    public boolean validateCoupon(Coupon coupon) {
        return LocalDate.now().isBefore(coupon.getDate());
    }

    /**
     * Validates if a unique coupon is still valid by checking if it's active and if the current date is before the expiration date.
     *
     * @param coupon The unique coupon to be validated
     * @return True if the coupon is valid, false otherwise
     */
    @Override
    public boolean validateCouponUnique(CouponUnique coupon) {
        if (coupon.getCoupon().isActive()) {
            return LocalDate.now().isBefore(coupon.getCoupon().getDate());
        } else {
            return false;
        }
    }

    /**
     * Marks a unique coupon as used by deactivating it.
     *
     * @param idCoupon The ID of the unique coupon to be marked as finished
     * @return True if successful, false otherwise
     */
    @Override
    public boolean finishCouponUnique(String idCoupon) {
        try {
            CouponUnique couponUnique = couponRepository.findById(idCoupon).get();
            couponUnique.getCoupon().setActive(false); // Deactivate the coupon
            couponRepository.save(couponUnique); // Save changes to the repository
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Marks a regular coupon as used and updates it for all users who have the coupon.
     *
     * @param coupon The coupon to be marked as finished
     * @return True if successful, false otherwise
     */
    @Override
    public boolean finishCouponIndividual(Coupon coupon) {
        try {
            Coupon updatedCoupon = coupon;
            updatedCoupon.setActive(false); // Mark the coupon as inactive

            // Update the coupon status for all users
            List<User> userList = userRepository.findAll();
            for (User user : userList) {
                if (user.getCouponsCode().contains(coupon)) {
                    user.getCouponsCode().remove(coupon); // Remove the old coupon
                    user.getCouponsCode().add(updatedCoupon); // Add the updated coupon
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Sends a coupon to the user's email address.
     *
     * @param coupon The coupon to be sent
     * @param idUser The ID of the user to whom the coupon will be sent
     * @return True if successful, false otherwise
     */
    @Override
    public boolean sendCoupon(Coupon coupon, String idUser) {
        try {
            // Send an email to the user with the coupon details
            emailService.sendEmail(
                    new EmailDTO(
                            userRepository.findById(idUser).get().getEmail(),
                            getMessage(coupon), // Message body
                            "Your Coupon is Here!" // Email subject
                    )
            );
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Generates the email message content for sending the coupon.
     *
     * @param coupon The coupon details
     * @return A formatted string containing the coupon details
     */
    private @NonNull String getMessage(Coupon coupon) {
        return "Hello,\n" +
                "\n" +
                "We are excited to inform you that you’ve received an exclusive coupon for your next purchase at Unieventos!\n" +
                "\n" +
                "Coupon Details:\n" +
                "\n" +
                "Code: " + coupon.getCode() + "\n" +
                "Discount: " + coupon.getDiscount_percentage() + "\n" +
                "Expiration Date: " + coupon.getDate() + "\n" +
                "You can use this coupon during checkout by entering the code in your shopping cart. It’s our way of thanking you for being a part of our community.\n" +
                "\n" +
                "If you have any questions, feel free to contact us. We hope to see you soon at Unieventos, and enjoy your discount!\n";
    }
}
