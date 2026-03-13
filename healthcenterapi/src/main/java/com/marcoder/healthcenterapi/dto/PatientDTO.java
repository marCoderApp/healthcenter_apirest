package com.marcoder.healthcenterapi.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientDTO {

    private Long patient_id;
    private String name;
    private String lastname;
    private String national_id_number;
    private String email;
    private String phone;
    private String address;
    private String gender;
    private String blood_type;
    private LocalDate born_date;

}
