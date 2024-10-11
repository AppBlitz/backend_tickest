package com.example.uniquindio.spring.service.imp.invoice;

import com.example.uniquindio.spring.model.documents.Invoice;
import com.example.uniquindio.spring.service.imp.email.EmailService;
import com.example.uniquindio.spring.service.interfaces.invoice.IOrderService;
import com.example.uniquindio.spring.service.interfaces.utils.IQRGeneration;
import com.example.uniquindio.spring.utils.QRCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IQRGeneration, IOrderService {
    @Autowired
    private EmailService emailService;

    @Autowired
    private QRCodeGenerator qrCodeGenerator;



    public void GenerateQR(Invoice invoice) throws Exception {
        // 1. Generate QR code with the order code
        String orderCode = invoice.getPurchaseOrder().getPurchaseOrderNumber(); // Suponiendo que tienes un código de orden
        byte[] qrCodeImage = qrCodeGenerator.generateQRCodeImage(orderCode, 250, 250);

        // 2. Generate order details as string
        String orderDetails = generateOrderDetails(invoice); // Método que genera los detalles de la orden

        // 3. Send email with order details and QR code
        emailService.sendOrderConfirmationEmail(invoice.getPurchaseOrder().getShoppingCart().getUserInformation().getEmail(), orderDetails, qrCodeImage);
    }

    private String generateOrderDetails(Invoice invoice) {
        // Aquí genera el string con los detalles de la orden de compra
        return "Order Details for invoice #" + invoice.getInvoiceNumber() + "\n" +
                "Customer: " + invoice.getPurchaseOrder().getShoppingCart().getUserInformation().getFullName() + "\n" +
                "Total: $" + invoice.getPurchaseOrder().getTotal();
    }
}
