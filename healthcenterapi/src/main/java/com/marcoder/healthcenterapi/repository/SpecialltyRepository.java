package com.marcoder.healthcenterapi.repository;

import com.marcoder.healthcenterapi.model.Speciallty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SpecialltyRepository extends JpaRepository<Speciallty,Long> {
    Speciallty findByName(String name);

    @Query("SELECT s FROM Speciallty s WHERE s.speciallty_id = :speciallty_id")
    Speciallty findBySpeciallty_Id(@Param("speciallty_id") Long id);
}
