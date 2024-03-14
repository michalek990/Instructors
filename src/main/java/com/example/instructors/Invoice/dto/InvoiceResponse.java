package com.example.instructors.Invoice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class InvoiceResponse {
    private Long id;
    private String invoiceNumber;
    private LocalDateTime invoiceDate;
    private BigDecimal amount;
    private String customerFirstname;
    private String customerLastname;
    private String customerEmail;
    private String gymPassType;
    private String instructorFirstname;
    private String instructorLastname;
    private String instructorEmail;
}
