package com.example.uniquindio.spring.service;

<<<<<<< HEAD
import com.example.uniquindio.spring.dto.emaildto.EmailDto;

=======
import com.example.uniquindio.spring.dto.emaildto.EamilDto;
>>>>>>> fabian
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:email.properties")
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String sender;

<<<<<<< HEAD
    public void sendEmailRegister(EmailDto dto) throws Exception {
=======

    public void sendFirstPurchaseCouponMail(EamilDto dto) throws Exception{
>>>>>>> fabian
        SimpleMailMessage mimeMessage = new SimpleMailMessage();

        mimeMessage.setFrom(sender);
        mimeMessage.setTo(dto.email());
        mimeMessage.setSubject("Primera compra en | Cupón de 10% de DCTO");
        mimeMessage.setText(String.format("Tu codigo de cupón para un 10%% de descuento es: %s","hello"));
        mimeMessage.setCc(dto.email());
        sendMessage(mimeMessage);
    }

<<<<<<< HEAD
    private void sendMessage(SimpleMailMessage mimeMessage) throws Exception {
=======
    private void sendMessage(SimpleMailMessage mimeMessage) throws Exception{
>>>>>>> fabian
        try {
            mailSender.send(mimeMessage);
        } catch (MailException e) {
        }
    }
}
