package com.example.uniquindio.spring.service.imp.email;

import com.example.uniquindio.spring.dto.emaildto.EmailDTO;
import com.example.uniquindio.spring.service.interfaces.email.IEmailService;
import com.example.uniquindio.spring.utils.PropertiesReader;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;
import org.springframework.scheduling.annotation.Async;
@Service
public class EmailService implements IEmailService {
    @Override
    //@Async
    public void sendEmail(@NonNull EmailDTO emailDTO) throws Exception {
        PropertiesReader reader = new PropertiesReader("resources/email.properties");

        Email email = EmailBuilder.startingBlank()
                .from(reader.getProperty("username"))
                .to(emailDTO.email())
                .withSubject(emailDTO.subject())
                .withPlainText(emailDTO.message())
                .buildEmail();


        try (Mailer mailer = MailerBuilder
                .withSMTPServer(reader.getProperty("host"), Integer.valueOf(reader.getProperty("port")), reader.getProperty("username"), reader.getProperty("password"))
                .withTransportStrategy(TransportStrategy.SMTP_TLS)
                .withDebugLogging(true)
                .buildMailer()) {


            mailer.sendMail(email);
        }


    }


}
