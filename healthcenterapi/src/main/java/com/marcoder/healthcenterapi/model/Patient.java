package com.marcoder.healthcenterapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patient_id;
    private String name;
    private String lastname;
    private String national_id_number;
    private String email;
    private String phone;
    private String address;
    private String gender;
    private String blood_type;
    private LocalDate born_date;



}
