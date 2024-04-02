package com.example.instructors.Class.dto;

import com.example.instructors.Entity.Activity;
import com.example.instructors.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActivityParticipant {
    private Activity activity;
    private User participant;
}
