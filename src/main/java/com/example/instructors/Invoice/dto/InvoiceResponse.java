package com.example.instructors.Invoice.dto;

import com.example.instructors.GymPass.dto.InvoiceGymPassResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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
}
