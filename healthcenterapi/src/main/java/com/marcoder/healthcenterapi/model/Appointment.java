package com.marcoder.healthcenterapi.model;

import com.marcoder.healthcenterapi.enums.AppointmentStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.boot.models.xml.spi.XmlDocument;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointment_id;
    private LocalDate date;
    private LocalTime time;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    private String reason;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String updatedBy = null;


    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "consulting_room_id", nullable = false)
    private Consulting_Room consulting_room;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
