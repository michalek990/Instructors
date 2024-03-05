package com.example.instructors.Message.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class MessageResponse {
    private Long id;
    private String content;
    private Timestamp timestamp;
    private String username;
    private String email;
}
