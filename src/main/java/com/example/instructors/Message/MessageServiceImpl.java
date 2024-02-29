package com.example.instructors.Message;

import com.example.instructors.Entity.Message;
import com.example.instructors.Message.dto.MessageRequest;
import com.example.instructors.Message.dto.MessageResponse;
import com.example.instructors.User.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;
    private final UserRepository userRepository;

    @Override
    public MessageResponse getMessageById(Long messageId) {
        Message message = messageRepository.getById(messageId);
        return messageMapper.mapToResponse(message);
    }

    @Override
    public Page<MessageResponse> getAllMessages(Pageable pageable) {
        Page<Message> messagePage = messageRepository.findAll(pageable);
        return messagePage.map(messageMapper::mapToResponse);
    }

    @Override
    public Page<MessageResponse> getAllMessagesByUserId(Pageable pageable, Long userId) {
        Page<Message> messagePage = messageRepository.getAllByUserId(pageable,userId);
        return messagePage.map(messageMapper::mapToResponse);
    }

    @Override
    public MessageResponse generateNewMessage(Long userId, MessageRequest messageRequest) {
        Message newMessage = new Message();
        newMessage.setContent(messageRequest.getContent());
        newMessage.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
        newMessage.setUser(userRepository.getById(userId));

        messageRepository.save(newMessage);

        return messageMapper.mapToResponse(newMessage);
    }

    @Override
    public void deleteMessage(Long messageId) {

    }
}
