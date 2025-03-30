package com.br.mypoint.mypoint_skate.domain.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.mypoint.mypoint_skate.domain.models.Point;

@Repository
public interface PointRepository extends JpaRepository<Point, Integer> {
    
}
