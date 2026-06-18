package com.marcoder.healthcenterapi.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdatePrescriptionDTO {

    private String medication_name;
    private String dosage;
    private String frequency;
    private String duration;

}
