package com.example.instructors.Class.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ClassRequest {
    private String name;
    private String description;
    private LocalDateTime date;
    private Integer numberOfParticipants;
}
