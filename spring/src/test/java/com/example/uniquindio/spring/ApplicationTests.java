package com.example.uniquindio.spring;

import com.example.uniquindio.spring.dto.emaildto.EmailDTO;
import com.example.uniquindio.spring.service.imp.email.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
@Autowired
EmailService emailService;

//	@Test
//	void mailTest(){
//
//		EmailDTO email = new EmailDTO("juand.guzmang@uqvirtual.edu.co", "mensaje de prueba unievetos","Prueba 1");
//        try {
//            emailService.sendEmail(email);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

}
