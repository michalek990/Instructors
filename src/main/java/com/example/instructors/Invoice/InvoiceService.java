package com.example.instructors.Invoice;

import com.example.instructors.Invoice.dto.InvoiceRequest;
import com.example.instructors.Invoice.dto.InvoiceResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InvoiceService {
    InvoiceResponse createInvoice(InvoiceRequest invoiceRequest);
    InvoiceResponse getInvoiceById(Long id);
    Page<InvoiceResponse> getAllInvoices(Pageable pageable);
    InvoiceResponse updateInvoice(Long id, InvoiceRequest invoiceRequest);
    void deleteInvoice(Long id);
}
