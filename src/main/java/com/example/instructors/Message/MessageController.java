package com.example.instructors.Message;

import com.example.instructors.Message.dto.MessageRequest;
import com.example.instructors.Message.dto.MessageResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/messages")
@AllArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @GetMapping("/all")
    public ResponseEntity<Page<MessageResponse>> getAllMessages(Pageable pageable){
        return ResponseEntity.ok(messageService.getAllMessages(pageable));
    }

    @GetMapping("/all-by-user/{userId}")
    public ResponseEntity<Page<MessageResponse>> getAllByUserId(Pageable pageable, @PathVariable Long userId){
        return ResponseEntity.ok(messageService.getAllMessagesByUserId(pageable, userId));
    }

    @PostMapping
    public ResponseEntity<MessageResponse> generateNewMessage(@RequestParam Long userId, @RequestBody MessageRequest request){
        MessageResponse response = messageService.generateNewMessage(userId, request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
