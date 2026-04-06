package com.marcoder.healthcenterapi.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorDTO {

    private Long doctor_id;
    private String license_number;
    private String national_id_number;
    private String email;
    private LocalDateTime start_at;
    private LocalDateTime end_at;
    private String specialty_id;
    private String user_id;
    private String consulting_room_id;
    private String status;

}
