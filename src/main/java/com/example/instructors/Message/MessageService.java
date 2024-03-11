package com.example.instructors.Message;

import com.example.instructors.Message.dto.MessageRequest;
import com.example.instructors.Message.dto.MessageResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface MessageService {

    MessageResponse getMessageById(Long messageId);
    Page<MessageResponse> getAllMessages(Pageable pageable);
    Page<MessageResponse> getAllMessagesByUserId(Pageable pageable, Long userId);

    MessageResponse generateNewMessage(Long userId, MessageRequest messageRequest);
    void deleteMessage(Long messageId);

}
