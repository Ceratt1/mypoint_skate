package com.br.mypoint.mypoint_skate.presentations.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.mypoint.mypoint_skate.application.services.SkaterServiceImpl;
import com.br.mypoint.mypoint_skate.presentations.requests.LoginRequest;
import com.br.mypoint.mypoint_skate.presentations.responses.LoginResponse;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class TokenController {
    
    private final JwtEncoder jwtEncoder;

    @Autowired
    private SkaterServiceImpl skaterServiceImpl;

    public TokenController(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {


    }
}
