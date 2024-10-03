package com.example.uniquindio.spring.service;

import com.example.uniquindio.spring.dto.emaildto.EmailDto;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:email.properties")
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String sender;

    public void sendEmailRegister(EmailDto dto) throws Exception {

        SimpleMailMessage mimeMessage = new SimpleMailMessage();

        mimeMessage.setFrom(sender);
        mimeMessage.setTo(dto.email());
        mimeMessage.setSubject(dto.subject());
        mimeMessage.setText(String.format(dto.message() + " %s", dto.code()));
        mimeMessage.setCc(dto.email());
        sendMessage(mimeMessage);
    }

    public void sendDescountCode(EmailDto dto) throws Exception {

        SimpleMailMessage mimeMessage = new SimpleMailMessage();

        mimeMessage.setFrom(sender);
        mimeMessage.setTo(dto.email());
        mimeMessage.setSubject(dto.subject());
        mimeMessage.setText(dto.message() + " " + dto.code());
        mimeMessage.setCc(dto.email());
        sendMessage(mimeMessage);
    }

    private void sendMessage(SimpleMailMessage mimeMessage) throws Exception {

        try {
            mailSender.send(mimeMessage);
        } catch (MailException e) {
        }
    }

    public void sendOrderConfirmationEmail(String to, String orderDetails, byte[] qrCodeImage) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);
        helper.setSubject("Order Confirmation");
        helper.setText(orderDetails, true);

        // Attach the QR code
        helper.addAttachment("order-qr.png", new ByteArrayResource(qrCodeImage));

        mailSender.send(message);
    }
}
