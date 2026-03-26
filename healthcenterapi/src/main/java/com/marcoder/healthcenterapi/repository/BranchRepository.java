package com.marcoder.healthcenterapi.repository;

import com.marcoder.healthcenterapi.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BranchRepository extends JpaRepository<Branch,Long> {

    @Override
    Optional<Branch> findById(Long aLong);

    Optional<Branch> findByName(String name);
}
