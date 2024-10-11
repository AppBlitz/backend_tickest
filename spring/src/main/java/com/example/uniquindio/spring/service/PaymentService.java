package com.example.uniquindio.spring.service;

import com.example.uniquindio.spring.model.documents.PurchaseOrder;
import com.example.uniquindio.spring.model.vo.items.Item;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.*;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.resources.payment.Payment;

import com.mercadopago.resources.preference.*;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@PropertySource("classpath:mercado-Pago.properties")
public class PaymentService {

    @Value("${mercado_pago_sample_access_token}")
    private String mercadoPagoAccessToken;

/*    public String CreatePayment(String idOrden) {

        //PurchaseOrder ordenGuardada = o(idOrden);
        List<PreferenceItemRequest> itemsPasarela = new ArrayList<>();
        // Crea un objeto de preferencia
        PreferenceClient client = new PreferenceClient();

        PreferenceItemRequest preferenceItemRequest = PreferenceItemRequest
                .builder()
                .title(payment.tittle())
                .quantity(payment.quantity())
                .unitPrice(BigDecimal.valueOf(payment.unitPrice()))
                .currencyId("COP").build();
        List<PreferenceItemRequest> items = new ArrayList<>();
        items.add(preferenceItemRequest);

        PreferencePayer payer = new PreferencePayer();


    }*/
}

