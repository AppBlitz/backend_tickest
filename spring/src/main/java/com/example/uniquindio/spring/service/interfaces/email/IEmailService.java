package com.example.uniquindio.spring.service.interfaces.email;

import com.example.uniquindio.spring.dto.emaildto.EmailDTO;
import lombok.NonNull;

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

    /**
     * Sends an email with an attached QR code image.
     *
     * @param emailDTO the data transfer object containing email details (recipient, subject, message)
     * @param qrCode   the QR code image as a byte array to be attached to the email
     * @throws Exception if an error occurs while sending the email or attaching the QR code
     */
    void sendEmailQR(@NonNull EmailDTO emailDTO, byte[] qrCode) throws Exception;
}
