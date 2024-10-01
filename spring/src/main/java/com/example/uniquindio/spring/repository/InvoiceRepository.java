package com.example.uniquindio.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.uniquindio.spring.model.vo.Invoice;
public interface InvoiceRepository extends MongoRepository<Invoice, String> {
}
