package com.example.instructors.User;

import com.example.instructors.Exception.ForbiddenException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    public void ensureUserHasRole(UserDetails userDetails, List<String> roles) {
        boolean hasRole = hasRole(userDetails, roles);
        if (!hasRole) {
            throw new ForbiddenException("User not permitted to perform this action!");
        }
    }

    public UserDetails getLoggedUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (UserDetails) authentication.getPrincipal();
    }

    private boolean hasRole(UserDetails userDetails, List<String> roles) {
        return userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(roles::contains);
    }
}
