package com.marcoder.healthcenterapi.model;

import com.marcoder.healthcenterapi.enums.BloodType;
import jakarta.persistence.*;
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

    @Enumerated(EnumType.STRING)
    private BloodType blood_type;

    private LocalDate born_date;

}
