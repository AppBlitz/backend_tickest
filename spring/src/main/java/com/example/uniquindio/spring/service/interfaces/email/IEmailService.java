package com.example.uniquindio.spring.service.interfaces.email;

import com.example.uniquindio.spring.dto.emaildto.EmailDTO;

public interface IEmailService {
    void sendEmail(EmailDTO emailDTO) throws Exception;
}
