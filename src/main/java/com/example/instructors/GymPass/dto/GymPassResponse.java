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
public class GymPassResponse {
    private Long id;
    private String type;
    private LocalDateTime expireDate;
    private BigDecimal price;
    private String instructorFirstname;
    private String instructorLastname;
    private String instructorEmail;
    private String userFirstname;
    private String userLastname;
    private String userEmail;
}
