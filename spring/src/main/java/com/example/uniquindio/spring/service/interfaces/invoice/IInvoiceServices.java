package com.example.uniquindio.spring.service.interfaces.invoice;

import com.example.uniquindio.spring.dto.invoicedto.OrderDTO;
import com.example.uniquindio.spring.model.documents.PurchaseOrder;

import com.example.uniquindio.spring.model.vo.information.CompanyInformation;
import com.example.uniquindio.spring.model.vo.payment.Pay;
import org.springframework.core.annotation.Order;

public interface IInvoiceServices {

    boolean sendInformation(String idUser, String idFactura);
    boolean createInvoice(PurchaseOrder order, CompanyInformation companyInformation, Pay pay);
    boolean addPayment(PurchaseOrder order, Pay pay);
}
