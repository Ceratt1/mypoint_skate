package com.br.mypoint.mypoint_skate.domain.models;

import java.util.Set;

import org.hibernate.annotations.ManyToAny;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.br.mypoint.mypoint_skate.presentations.requests.LoginRequest;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
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
    @Column(name = "skater_id")
    private Integer id;
    
    @Column(nullable = false, length = 50, unique=true)
    private String username;
    
    private String password;


    @ManyToAny(fetch= FetchType.EAGER)
    @JoinTable(name = "tb_skater_role",
    joinColumns = @JoinColumn(name = "skater_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Point> points;

    public boolean LoginCorret(LoginRequest loginRequest, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches( loginRequest.password(), this.password); 

    }


}
