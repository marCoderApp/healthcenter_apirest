package com.marcoder.healthcenterapi.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PrescriptionDTO {

    private Long prescription_id;
    private String medication_name;
    private String dosage;
    private String frequency;
    private String duration;
    private LocalDateTime created_at;
    private String medical_record_id;

}
