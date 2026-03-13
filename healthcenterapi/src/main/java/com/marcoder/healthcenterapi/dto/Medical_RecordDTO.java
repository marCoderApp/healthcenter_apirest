package com.marcoder.healthcenterapi.dto;

import java.time.LocalDateTime;

public class Medical_RecordDTO {

    private Long medical_record_id;
    private String symptoms;
    private String diagnosis;
    private String treatment_notes;
    private String observations;
    private LocalDateTime createdAt;
    private String patient_id;
    private String doctor_id;
    private String appointment_id;

}
