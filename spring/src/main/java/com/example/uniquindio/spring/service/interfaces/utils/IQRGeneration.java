package com.example.uniquindio.spring.service.interfaces.utils;

import com.example.uniquindio.spring.dto.invoicedto.OrderDTO;
import com.example.uniquindio.spring.dto.invoicedto.OrderInformationDTO;
import com.example.uniquindio.spring.exception.invoice.QRGenerationException;
import com.example.uniquindio.spring.model.vo.payment.Pay;

public interface IQRGeneration {
    OrderInformationDTO getOrderInformation(OrderDTO orderDTO);
    byte[] generateQR(String idOrder) throws QRGenerationException; //URL of image
    boolean saveQR(String QR);
}
