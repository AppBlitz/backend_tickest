package com.example.uniquindio.spring.Controller.implement;

import com.example.uniquindio.spring.dto.eventdto.CreateEventDto;
import com.example.uniquindio.spring.model.documents.Event;
import com.example.uniquindio.spring.model.vo.items.Payment;
import com.example.uniquindio.spring.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.*;



public class PaymentControllerImplement {

    PaymentService paymentService;

    @Value("${mercado_pago_access_token}")
    private String mercadoPagoAccessToken;

 /*   @PostMapping("/create")
    public ResponseEntity<String> createPayment(@RequestBody PaymentRequest paymentRequest) {
        // Create a new payment using the Mercado Pago SDK
        MercadoPago mp = new MercadoPago(mercadoPagoAccessToken);
        Payment payment = mp.createPayment(paymentRequest);

        // Return the payment ID
        return ResponseEntity.ok(payment.getId());
    }

    @PostMapping("/get/{paymentId}")
    public ResponseEntity<Payment> getPayment(@PathVariable String paymentId) {
        // Get the payment using the Mercado Pago SDK
        MercadoPago mp = new MercadoPago(mercadoPagoAccessToken);
        Payment payment = mp.getPayment(paymentId);

        // Return the payment object
        return ResponseEntity.ok(payment);
    }

    @PostMapping("/cancel/{paymentId}")
    public ResponseEntity<String> cancelPayment(@PathVariable String paymentId) {
        // Get the payment using the Mercado Pago SDK
        MercadoPago mp = new MercadoPago(mercadoPagoAccessToken);
        Payment payment = mp.getPayment(paymentId);

        // Cancel the payment
        payment.cancel();

        // Return a success message
        return ResponseEntity.ok("Payment cancelled successfully");
    }
}*/

}
