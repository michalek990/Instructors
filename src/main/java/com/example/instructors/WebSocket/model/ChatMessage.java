package com.example.instructors.WebSocket.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class ChatMessage {
    private String content;
    private String sender;
    private MessageType type;
}
