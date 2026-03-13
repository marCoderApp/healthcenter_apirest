package com.marcoder.healthcenterapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Speciallty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long speciallty_id;
    private String name;


}
