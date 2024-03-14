package com.example.instructors.Invoice;

import com.example.instructors.Components.Aspect.InstructorOnly;
import com.example.instructors.Invoice.dto.InvoiceRequest;
import com.example.instructors.Invoice.dto.InvoiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/invoices")
@InstructorOnly
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService;

    @PostMapping
    public ResponseEntity<InvoiceResponse> createInvoice(@RequestBody InvoiceRequest invoiceRequest) {
        InvoiceResponse response = invoiceService.createInvoice(invoiceRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
