package com.example.instructors.Security;

import com.example.instructors.Security.dto.AuthenticationRequest;
import com.example.instructors.Security.dto.AuthenticationResponse;
import com.example.instructors.Security.dto.RegisterRequest;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @GetMapping("/verify")
    public ResponseEntity<?> verifyAccount(@RequestParam("code") String verificationCode) {
        boolean isVerified = authenticationService.verify(verificationCode);
        return isVerified
                ? ResponseEntity.ok().body("Account successfully verified.")
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or expired verification code.");
    }
}
