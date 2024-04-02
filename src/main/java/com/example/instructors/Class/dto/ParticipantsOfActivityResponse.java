package com.example.instructors.Class.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantsOfActivityResponse {
    private Long id;
    private String email;
    private String firstname;
    private String lastname;
}
