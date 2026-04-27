package com.marcoder.healthcenterapi.repository;

import com.marcoder.healthcenterapi.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}
