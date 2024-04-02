package com.example.instructors.Class.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddParticipantResponse {
    private Long id;
    private String email;
    private String firstname;
    private String lastname;
    private String activityName;
    private LocalDateTime activityDate;
}
