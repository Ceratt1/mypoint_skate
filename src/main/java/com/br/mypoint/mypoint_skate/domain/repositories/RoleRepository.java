package com.br.mypoint.mypoint_skate.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.mypoint.mypoint_skate.domain.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    
}
