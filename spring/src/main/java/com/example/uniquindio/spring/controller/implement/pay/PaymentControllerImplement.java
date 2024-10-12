package com.example.uniquindio.spring.Controller.implement.pay;

import com.example.uniquindio.spring.Controller.interfaces.pay.PaymentController;
import com.example.uniquindio.spring.dto.utils.JWTUtilsdto.MensajeDto;
import com.example.uniquindio.spring.service.imp.pay.PaymentService;
import com.mercadopago.resources.preference.Preference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("payment")
public class PaymentControllerImplement implements PaymentController {

    @Autowired
    PaymentService paymentService;

    @RequestMapping(value = "/realizar-pago", method = RequestMethod.POST)
    public ResponseEntity<MensajeDto<Preference>> realizarPago(@RequestParam("idOrden") String idOrden) throws Exception {
        return ResponseEntity.ok().body(new MensajeDto<>(false, paymentService.CreatePayment(idOrden)));
    }


    @RequestMapping(value = "/notificacion-pago", method = RequestMethod.POST)
    public void recibirNotificacionMercadoPago(@RequestBody Map<String, Object> requestBody) {
        paymentService.notifyMercadoPago(requestBody);
    }



}
