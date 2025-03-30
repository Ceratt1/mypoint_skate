package com.br.mypoint.mypoint_skate.domain.models;

import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "skater")
public class Skater {
    

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    private String username;
    
    private String password;

    private Set<Role> roles;

}
