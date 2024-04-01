package com.example.instructors.User;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {

    void ensureUserHasRole(UserDetails userDetails, List<String> roles);
    UserDetails getLoggedUser();
}
