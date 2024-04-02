package com.example.instructors.Class.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActivityResponse {
    private Long id;
    private String name;
    private String description;
    private String date;
    private Integer numberOfParticipants;
    private String instructorEmail;
    private String instructorFirstname;
    private String instructorLastname;
}
