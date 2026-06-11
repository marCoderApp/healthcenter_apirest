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

    @Lob
    @Column(columnDefinition = "TEXT")
    private String symptoms;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String diagnosis;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String treatment_notes;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String observations;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String updatedBy = null;
    private Boolean isActive = true;

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
