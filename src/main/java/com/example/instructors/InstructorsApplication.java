package com.example.instructors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class InstructorsApplication {

    public static void main(String[] args) {
        SpringApplication.run(InstructorsApplication.class, args);
    }
}
