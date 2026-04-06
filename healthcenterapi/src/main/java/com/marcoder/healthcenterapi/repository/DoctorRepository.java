package com.marcoder.healthcenterapi.repository;

import com.marcoder.healthcenterapi.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {

    Optional<Doctor> findById(Long id);

    @Query("SELECT d FROM Doctor d WHERE d.speciallty.speciallty_id = :speciallty_id")
    List<Doctor> findBySpecialltyId(@Param("speciallty_id") Long speciallty_id);

    @Query("SELECT d FROM Doctor d WHERE d.national_id_number = :national_id_number")
    Doctor findByNationalIdNumber(@Param("national_id_number") String national_id_number);

    @Query("SELECT d FROM Doctor d WHERE d.consulting_room.consulting_room_id = :consulting_room_id")
    List<Doctor> findByConsulting_RoomId(@Param("consulting_room_id") Long consulting_room_id);

    @Query("SELECT d FROM Doctor d WHERE d.email = :email")
    Doctor findByEmail(@Param("email") String email);
}
