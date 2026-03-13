package com.marcoder.healthcenterapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctor_id;
    private String license_number;
    private String national_id_number;
    private String email;
    private LocalDateTime started_at;

    @ManyToOne
    @JoinColumn(name = "speciallty_id", nullable = false)
    private Speciallty speciallty;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "consulting_room", nullable = false)
    private Consulting_Room consulting_room;



}
