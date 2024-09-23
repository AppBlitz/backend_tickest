package com.example.uniquindio.spring.service;

import com.example.uniquindio.spring.dto.emaildto.EamilDto;
import com.example.uniquindio.spring.exceptions.MailSendingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String sender;


    public void sendFirstPurchaseCouponMail(EamilDto dto) throws MailSendingException {
        SimpleMailMessage mimeMessage = new SimpleMailMessage();

        mimeMessage.setFrom("karlcorralesmovil@gmail.com");
        mimeMessage.setTo(dto.email());
        mimeMessage.setSubject("Primera compra en | Cupón de 10% de DCTO");
        mimeMessage.setText(String.format("Tu codigo de cupón para un 10%% de descuento es: %s"));
        mimeMessage.setCc(dto.email());
        sendMessage(mimeMessage);
    }

    private void sendMessage(SimpleMailMessage mimeMessage) throws MailSendingException {
        try {
            mailSender.send(mimeMessage);
        } catch (MailException e) {
            throw new MailSendingException(e.getMessage());
        }
    }
}
