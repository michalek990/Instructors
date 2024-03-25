package com.example.instructors.Invoice;

import com.example.instructors.Invoice.dto.InvoiceRequest;
import com.example.instructors.Invoice.dto.InvoiceResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InvoiceService {
    InvoiceResponse createInvoice();
    InvoiceResponse getInvoiceById(Long id);
    List<InvoiceResponse> getAllByUserUsername(String username);
    Page<InvoiceResponse> getAllInvoices(Pageable pageable);
    InvoiceResponse updateInvoice(Long id, InvoiceRequest invoiceRequest);
    void deleteInvoice(Long id);
}
