package com.br.mypoint.mypoint_skate.application.services;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.br.mypoint.mypoint_skate.domain.models.Skater;
import com.br.mypoint.mypoint_skate.domain.repositories.SkaterRepository;
import com.br.mypoint.mypoint_skate.domain.services.SkaterService;
import com.br.mypoint.mypoint_skate.presentations.requests.LoginRequest;

public class SkaterServiceImpl implements SkaterService{


    @Autowired
    private SkaterRepository skaterRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Skater findByEmail(LoginRequest loginRequest) {

        try {
            
            Skater skater = skaterRepository.findByUsername(loginRequest.username()).orElseThrow(() -> new BadCredentialsException("Invalid username or password"));

            if(skater.LoginCorret(loginRequest, bCryptPasswordEncoder))
                return skater;
            else
                throw new BadCredentialsException("Invalid username or password");


            

        } catch (Exception e) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Unauthorized");
        }

        throw new UnsupportedOperationException("Unimplemented method 'findByEmail'");
    }
    
}
