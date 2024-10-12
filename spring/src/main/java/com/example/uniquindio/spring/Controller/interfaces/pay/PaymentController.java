package com.example.uniquindio.spring.Controller.interfaces.pay;

import com.example.uniquindio.spring.dto.utils.JWTUtilsdto.MensajeDto;
import com.mercadopago.resources.preference.Preference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface PaymentController {

    public ResponseEntity<MensajeDto<Preference>> realizarPago(@RequestParam("idOrden") String idOrden) throws Exception;

    public void recibirNotificacionMercadoPago(@RequestBody Map<String, Object> requestBody);
}
