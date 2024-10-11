package com.example.uniquindio.spring.service.interfaces.utils;

import com.example.uniquindio.spring.dto.invoicedto.OrderDTO;
import com.example.uniquindio.spring.dto.invoicedto.OrderInformationDTO;
import com.example.uniquindio.spring.exception.invoice.QRGenerationException;
import com.example.uniquindio.spring.model.vo.payment.Pay;

/**
 * Interface for QR code generation services.
 * Defines methods for generating and managing QR codes associated with orders.
 */
public interface IQRGeneration {

    /**
     * Retrieves order information based on the provided OrderDTO.
     *
     * @param orderDTO the data transfer object containing order details
     * @return an OrderInformationDTO containing detailed order information
     */
    OrderInformationDTO getOrderInformation(OrderDTO orderDTO);

    /**
     * Generates a QR code for the specified order.
     *
     * @param idOrder the ID of the order for which to generate the QR code
     * @return a byte array representing the generated QR code image
     * @throws QRGenerationException if an error occurs during QR code generation
     */
    byte[] generateQR(String idOrder) throws QRGenerationException; // URL of image

    /**
     * Saves the generated QR code.
     *
     * @param QR the QR code data to save
     * @return true if the QR code is successfully saved, false otherwise
     */
    boolean saveQR(String QR);
}
