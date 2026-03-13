package com.marcoder.healthcenterapi.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentDTO {

    private Long appointment_id;
    private LocalDate date;
    private LocalTime time;
    private String status;
    private String reason;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String patient_id;
    private String user_id;
    private String doctor_id;
    private String consulting_room_id;

}
