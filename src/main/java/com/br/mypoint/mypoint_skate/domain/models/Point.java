package com.br.mypoint.mypoint_skate.domain.models;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "point")
@Getter
@Setter
public class Point {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "point_id")
    private long id;
    
    
    @Column(nullable = false, length = 50, unique=true)
    private String name;

    @Column(nullable = false)
    private long coordinateX;

    @Column(nullable = false)
    private long coordinateY;

    @Column(length=250)
    private String description;

    @CreationTimestamp
    @Column(updatable = false)
    private Instant createdAt;

    @ManyToOne
    @JoinColumn(name = "skater_id", nullable = false)
    private Skater creator;

}
