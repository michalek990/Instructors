package com.example.instructors.Message;

import com.example.instructors.Entity.Message;
import com.example.instructors.Message.dto.MessageRequest;
import com.example.instructors.Message.dto.MessageResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MessageMapper {

    @Mapping(target = "username", source = "user.username")
    @Mapping(target = "email", source = "user.email")
    MessageResponse mapToResponse(Message message);

    Message mapToMessage(MessageRequest messageRequest);
}
