package com.br.mypoint.mypoint_skate.presentations.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.mypoint.mypoint_skate.domain.services.SkaterService;
import com.br.mypoint.mypoint_skate.presentations.requests.LoginRequest;
import com.br.mypoint.mypoint_skate.presentations.responses.LoginResponse;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class TokenController {
    

    @Autowired
    private SkaterService skaterService;



    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {

        return skaterService.findByUsername(loginRequest);

    }
}
