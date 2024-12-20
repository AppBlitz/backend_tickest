package com.example.uniquindio.spring.service.imp.email;

import com.example.uniquindio.spring.dto.emaildto.EmailDTO;
import com.example.uniquindio.spring.service.interfaces.email.IEmailService;
import com.example.uniquindio.spring.utils.PropertiesReader;
import jakarta.mail.util.ByteArrayDataSource;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;
import org.springframework.scheduling.annotation.Async;

@Service
@PropertySource("classpath:email.properties")
public class EmailService implements IEmailService {


    @Value("${spring.mail.username}")
    String username;

    @Value("${spring.mail.host}")
    String host;

    @Value("${spring.mail.port}")
    int port;

    @Value("${spring.mail.password}")
    String password;

    @Override
    //@Async
    public void sendEmail(@NonNull EmailDTO emailDTO) throws Exception {

        Email email = EmailBuilder.startingBlank().from(username)
                .to(emailDTO.email())
                .withSubject(emailDTO.subject())
                .withPlainText(emailDTO.message())
                .buildEmail();


        try (Mailer mailer = MailerBuilder
                .withSMTPServer(host, Integer.valueOf(port), username, password)
                .withTransportStrategy(TransportStrategy.SMTP_TLS)
                .withDebugLogging(true)
                .buildMailer()) {


            mailer.sendMail(email);
        }


    }

    @Override
    @Async
    public void sendEmailQR(@NonNull EmailDTO emailDTO, byte[] qrCode) throws Exception {
        PropertiesReader reader = new PropertiesReader("resources/email.properties");

        // Construir el correo electrónico con el QR adjunto
        Email email = EmailBuilder.startingBlank()
                .from(reader.getProperty("username"))
                .to(emailDTO.email())
                .withSubject(emailDTO.subject())
                .withPlainText(emailDTO.message())
                .withAttachment("QR_Code.png", new ByteArrayDataSource(qrCode, "image/png"), "image/png")  // Adjuntar el QR
                .buildEmail();

        try (Mailer mailer = MailerBuilder
                .withSMTPServer(reader.getProperty("host"), Integer.valueOf(reader.getProperty("port")), reader.getProperty("username"), reader.getProperty("password"))
                .withTransportStrategy(TransportStrategy.SMTP_TLS)
                .withDebugLogging(true)
                .buildMailer()) {

            // Enviar el correo
            mailer.sendMail(email);
        }
    }
}


