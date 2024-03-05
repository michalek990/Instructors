package com.example.instructors.Components;

import com.example.instructors.Entity.GymPass;
import com.example.instructors.GymPass.GymPassRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ScheduledMailSender {

    private final GymPassRepository gymPassRepository;
    private final EmailService emailService;

    @Scheduled(cron = "* * 0 9 * * ")
    public void checkGymPassAndNotify(){
        List<GymPass> endingGymPasses = gymPassRepository.findEndingGymPasses();
        for(GymPass gymPass : endingGymPasses){
            emailService.sendVerificationEmail(
                    gymPass.getInstructor().getEmail(),
                    "Przypomnienie o wygaśnięciu karnetu",
                    "Twój karnet " + gymPass.getType() + " kończy się dzisiaj"
                    );
        }
    }
}
