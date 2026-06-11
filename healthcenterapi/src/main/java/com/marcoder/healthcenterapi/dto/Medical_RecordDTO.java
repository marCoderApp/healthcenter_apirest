package com.marcoder.healthcenterapi.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Medical_RecordDTO {

    private Long medical_record_id;
    private String symptoms;
    private String diagnosis;
    private String treatment_notes;
    private String observations;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String updatedBy;
    private String patient_id;
    private String doctor_id;
    private String appointment_id;
    private Boolean isActive;

}
