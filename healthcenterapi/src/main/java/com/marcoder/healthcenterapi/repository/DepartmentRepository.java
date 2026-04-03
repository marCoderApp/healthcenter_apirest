package com.marcoder.healthcenterapi.repository;

import com.marcoder.healthcenterapi.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

    @Override
    Optional<Department> findById(Long id);

    Optional<Department> findByName(String name);

    @Query("SELECT d FROM Department d WHERE d.branch.branch_id = :branch_id")
    Optional<Department> findByBranchId(@Param("branch_id") Long branch_id);
}
