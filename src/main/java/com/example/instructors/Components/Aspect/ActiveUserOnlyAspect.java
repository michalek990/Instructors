package com.example.instructors.Components.Aspect;

import com.example.instructors.Entity.User;
import com.example.instructors.Exception.ForbiddenException;
import com.example.instructors.User.UserService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class ActiveUserOnlyAspect {

    private final UserService userService;

    @Before("@annotation(ActiveUserOnly)")
    public void checkIsUserActive(){
        User userDetails = (User) userService.getLoggedUser();
        if(!userDetails.isActive()){
            throw new ForbiddenException("User account is not verified yet");
        }
    }
}
