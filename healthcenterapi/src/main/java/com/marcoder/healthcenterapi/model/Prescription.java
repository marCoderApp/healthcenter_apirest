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
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prescription_id;
    private String medication_name;
    private String dosage;
    private String frequency;
    private String duration;
    private LocalDateTime created_at;

    @ManyToOne
    @JoinColumn(name = "medical_record_id", nullable = false)
    private Medical_Record medical_record;
}
