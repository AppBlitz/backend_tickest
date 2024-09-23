package com.example.uniquindio.spring.service;

import com.example.uniquindio.spring.dto.emaildto.EamilDto;
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


    public void sendFirstPurchaseCouponMail(EamilDto dto) throws Exception{
        SimpleMailMessage mimeMessage = new SimpleMailMessage();

        mimeMessage.setFrom("amaeventosuq@gmail.com");
        mimeMessage.setTo(dto.email());
        mimeMessage.setSubject("Primera compra en AmaEventos | Cupón de 10% de DCTO");
        mimeMessage.setText(String.format("Tu codigo de cupón para un 10%% de descuento es: %s"));
        mimeMessage.setCc(dto.email());
        sendMessage(mimeMessage);
    }

    private void sendMessage(SimpleMailMessage mimeMessage) throws Exception{
        try {
            mailSender.send(mimeMessage);
        } catch (MailException e) {
        }
    }
}
