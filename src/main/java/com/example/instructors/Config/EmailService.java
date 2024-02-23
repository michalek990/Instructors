package com.example.instructors.Config;

import lombok.AllArgsConstructor;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;
    private final ResourceLoader resourceLoader;

    public void sendVerificationEmail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("michal.grzeszuk.dodat@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
    }
}
