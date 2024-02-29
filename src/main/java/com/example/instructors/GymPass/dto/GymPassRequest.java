package com.example.instructors.GymPass.dto;

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
public class GymPassRequest {
    private String type;
    private LocalDateTime expireDate;
    private BigDecimal price;
    private String instructorEmail;
    private String userEmail;
}
