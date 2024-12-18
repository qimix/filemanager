package ru.netology.filemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import ru.netology.filemanager.dto.AuthRequest;
import ru.netology.filemanager.dto.AuthResponse;
import ru.netology.filemanager.util.JWTUtils;

@RestController
public class AuthenticationController {
    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public AuthResponse create(@RequestBody AuthRequest authRequest) {
        System.out.println("=====================================");
        System.out.println(authRequest.getUsername());
        System.out.println(authRequest.getPassword());
        System.out.println("=====================================");
        var authentication = new UsernamePasswordAuthenticationToken(
                authRequest.getUsername(), authRequest.getPassword());

        authenticationManager.authenticate(authentication);
        AuthResponse authResponse = new AuthResponse(jwtUtils.generateToken(authRequest.getUsername()));
        System.out.println("=====================================");
        System.out.println(authResponse.getAuthToken());
        System.out.println("=====================================");
        return authResponse;
    }
}
