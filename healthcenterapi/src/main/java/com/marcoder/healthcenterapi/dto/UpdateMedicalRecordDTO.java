package com.marcoder.healthcenterapi.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateMedicalRecordDTO {

    private String diagnosis;
    private String treatment_notes;
    private String observations;
    private String updatedBy;

}
