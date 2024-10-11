package com.example.uniquindio.spring.service.imp.invoice;

import com.example.uniquindio.spring.dto.emaildto.EmailDTO;
import com.example.uniquindio.spring.dto.invoicedto.OrderDTO;
import com.example.uniquindio.spring.model.documents.PurchaseOrder;
import com.example.uniquindio.spring.model.documents.User;
import com.example.uniquindio.spring.model.vo.payment.Pay;
import com.example.uniquindio.spring.repository.OrderRepository;
import com.example.uniquindio.spring.repository.ShoppingCartRepository;
import com.example.uniquindio.spring.repository.UserRepository;
import com.example.uniquindio.spring.service.imp.email.EmailService;
import com.example.uniquindio.spring.service.imp.user.UserService;
import com.example.uniquindio.spring.service.interfaces.invoice.IInvoiceServices;
import com.example.uniquindio.spring.utils.QRCodeGenerator;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.uniquindio.spring.repository.InvoiceRepository;
import com.example.uniquindio.spring.model.documents.Invoice;

@Service
public class InvoiceServices  implements IInvoiceServices {

    @Autowired
    EmailService emailService;
    @Autowired
    QRCodeGenerator qrCodeGenerator;
    @Autowired
    UserService userService;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ShoppingCartRepository shoppingCartRepository;
    @Autowired
    SequenceGeneratorService sequenceGeneratorService;
    @Autowired
    InvoiceRepository invoiceRepository;

    public Invoice createInvoice(Invoice invoice) {
        // Generate auto-incremented invoice number
        invoice.setInvoiceNumber(sequenceGeneratorService.generateSequence("invoice"));

        // Save the invoice to the database
        return invoiceRepository.save(invoice);
    }
    @Override
    public boolean addPayment(OrderDTO orderDTO, Pay pay) {

        return false;
    }
    @Override
    public boolean sendInformation(String idUser, String idInvoice) {
        try {
            User user = userRepository.findById(idUser).get();
            PurchaseOrder order = orderRepository.findByShoppingCart(shoppingCartRepository.findById(user.getIdShoppingCart()).get()).get();
            EmailDTO emailDTO = new EmailDTO(user.getEmail(),generateOrderDetails(idInvoice),"Aviso de realizacion de compra");
            emailService.sendEmail(emailDTO);
            return true;
        }catch (Exception e){
            return  false;
        }
    }
    private @NonNull String generateOrderDetails(@NonNull String idInvoice) {
        Invoice invoice = invoiceRepository.findById(idInvoice).get();
        return "Detalles de la orden de compra #" + invoice.getInvoiceNumber() + "\n" +
                "Customer: " + invoice.getPurchaseOrder().getShoppingCart().getUserInformation().getFullName() + "\n" +
                "Total: $" + invoice.getPurchaseOrder().getTotal();
    }

}
