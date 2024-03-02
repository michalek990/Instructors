package com.example.instructors.Message.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
public class MessageResponse {
    private Long id;
    private String content;
    private Timestamp timestamp;
    private String username;
    private String email;
}
