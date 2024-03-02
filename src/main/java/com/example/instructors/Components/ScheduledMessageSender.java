package com.example.instructors.Components;

import com.example.instructors.Entity.GymPass;
import com.example.instructors.Entity.Message;
import com.example.instructors.GymPass.GymPassRepository;
import com.example.instructors.Message.MessageService;
import com.example.instructors.Message.dto.MessageRequest;
import com.example.instructors.Message.dto.MessageResponse;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ScheduledMessageSender {

    private final MessageService messageService;
    private final GymPassRepository gymPassRepository;

    @Scheduled(cron = "* * 9 * * *")
    public void checkGymPassAndSendMessage(){
        MessageRequest messageRequest = new MessageRequest();
        messageRequest.setContent("Your gym pass is expired! Please visit our website" +
                                  "to extend your pass.");

        List<GymPass> endingGymPasses = gymPassRepository.findEndingGymPasses();
        for(GymPass gymPass : endingGymPasses){
            messageService.generateNewMessage(
                    gymPass.getInstructor().getId(),
                    messageRequest
            );
        }
    }
}
