package com.example.instructors.Invoice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceRequest {
    private String invoiceNumber;
    private LocalDateTime invoiceDate;
    private String CustomerFirstname;
    private String CustomerLastname;
}
