package com.example.instructors.GymPass.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class InvoiceGymPassResponse {
    private Long id;
    private String type;
    private LocalDateTime expireDate;
    private BigDecimal price;
}
