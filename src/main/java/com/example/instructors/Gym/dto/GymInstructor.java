package com.example.instructors.Gym.dto;

import com.example.instructors.Entity.Gym;
import com.example.instructors.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GymInstructor {
    private Gym gym;
    private User instructor;
}
