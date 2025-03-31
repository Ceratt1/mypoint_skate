package com.br.mypoint.mypoint_skate.application.services;

import org.springframework.web.client.HttpClientErrorException;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import com.br.mypoint.mypoint_skate.domain.models.Skater;
import com.br.mypoint.mypoint_skate.domain.repositories.SkaterRepository;
import com.br.mypoint.mypoint_skate.domain.services.SkaterService;
import com.br.mypoint.mypoint_skate.presentations.requests.LoginRequest;
import com.br.mypoint.mypoint_skate.presentations.responses.LoginResponse;


@Service
public class SkaterServiceImpl implements SkaterService{



    @Autowired
    private SkaterRepository skaterRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    private JwtEncoder jwtEncoder;




    

    @Override
    public ResponseEntity<LoginResponse> findByUsername(LoginRequest loginRequest) {

        try {
            
            Skater skater = skaterRepository.findByUsername(loginRequest.username()).orElseThrow(() -> new BadCredentialsException("Invalid username or password"));

            if(skater.LoginCorret(loginRequest, bCryptPasswordEncoder)){
                var now = Instant.now();
                var expiresIn = 500L;
                JwtClaimsSet claims = JwtClaimsSet.builder()
                            .issuer("mybackend")
                            .subject(skater.getId().toString())
                            .issuedAt(now)
                            .expiresAt(now.plusSeconds(expiresIn))
                            .build();

                var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

                return ResponseEntity.ok(new LoginResponse(jwtValue, expiresIn));

                    
                } else {
                    throw new BadCredentialsException("Invalid username or password");
                }

        } catch (BadCredentialsException e) {
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "Invalid username or password");
        }

    }
    
}
