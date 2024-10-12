package com.example.uniquindio.spring.service.interfaces.pay;

import com.mercadopago.resources.preference.Preference;

import java.util.Map;

public interface IPaymentService {

    /**
     * create preferences of Payment with MercadoPago
     *
     * @param idOrden
     * @return
     * @throws Exception
     */
    public Preference CreatePayment(String idOrden) throws Exception;

    /**
     * send notify of pay
     * @param request
     */
    public void notifyMercadoPago(Map<String, Object> request);
}
