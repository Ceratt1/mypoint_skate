package com.br.mypoint.mypoint_skate.domain.services;


import com.br.mypoint.mypoint_skate.domain.models.Skater;
import com.br.mypoint.mypoint_skate.presentations.requests.LoginRequest;

public interface SkaterService {


    Skater findByEmail(LoginRequest username);


}
