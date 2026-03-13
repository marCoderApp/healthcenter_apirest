package com.marcoder.healthcenterapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Medical_Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medical_record_id;
    private String symptoms;
    private String diagnosis;
    private String treatment_notes;
    private String observations;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @OneToOne
    @JoinColumn(name = "appointment_id", nullable = false)
    private Appointment appointment;

}
