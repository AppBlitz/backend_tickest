package com.example.uniquindio.spring.service.interfaces.email;

import com.example.uniquindio.spring.dto.emaildto.EmailDTO;

/**
 * Interface for email services.
 * Defines the contract for sending emails.
 */
public interface IEmailService {

    /**
     * Sends an email using the provided EmailDTO object.
     *
     * @param emailDTO the data transfer object containing email details (recipient, subject, message)
     * @throws Exception if an error occurs while sending the email
     */
    void sendEmail(EmailDTO emailDTO) throws Exception;
}
