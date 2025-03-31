package com.br.mypoint.mypoint_skate.domain.services;


import org.springframework.http.ResponseEntity;

import com.br.mypoint.mypoint_skate.presentations.requests.LoginRequest;
import com.br.mypoint.mypoint_skate.presentations.responses.LoginResponse;

public interface SkaterService {


    ResponseEntity<LoginResponse> findByUsername(LoginRequest username);


}
