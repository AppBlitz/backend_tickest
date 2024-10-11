package com.example.uniquindio.spring.service.interfaces.invoice;

import com.example.uniquindio.spring.dto.invoicedto.OrderDTO;
import com.example.uniquindio.spring.model.vo.payment.Pay;

public interface IInvoiceServices {
    boolean addPayment(OrderDTO orderDTO, Pay pay);
    boolean sendInformation(String idUser, String idFactura);
}
