package com.example.uniquindio.spring.service.invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.uniquindio.spring.repository.InvoiceRepository;
import com.example.uniquindio.spring.model.documents.Invoice;

@Service
public class InvoiceServices {

    private final InvoiceRepository invoiceRepository;
    private final SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public InvoiceServices(InvoiceRepository invoiceRepository, SequenceGeneratorService sequenceGeneratorService) {
        this.invoiceRepository = invoiceRepository;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    public Invoice createInvoice(Invoice invoice) {
        // Generate auto-incremented invoice number
        invoice.setInvoiceNumber(sequenceGeneratorService.generateSequence("invoice"));

        // Save the invoice to the database
        return invoiceRepository.save(invoice);
    }
}
