package com.example.instructors.Activity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActivityRequest {
    private String name;
    private String description;
    private LocalDateTime date;
    private Integer numberOfParticipants;
}
