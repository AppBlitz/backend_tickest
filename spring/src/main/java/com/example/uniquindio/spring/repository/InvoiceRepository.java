package com.example.uniquindio.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.uniquindio.spring.model.documents.Invoice;
public interface InvoiceRepository extends MongoRepository<Invoice, String> {
}
