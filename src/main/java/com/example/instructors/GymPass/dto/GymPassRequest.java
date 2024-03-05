package com.example.instructors.GymPass.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class GymPassRequest {
    private String type;
    private LocalDateTime expireDate;
    private BigDecimal price;
    private String instructorEmail;
    private String userEmail;
}
