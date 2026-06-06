package com.marcoder.healthcenterapi.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateAppointmentDTO {

    private LocalTime time;
    private LocalDate date;
    private String status;
    private LocalDateTime updatedAt;
    private String updatedBy;

}
