package com.marcoder.healthcenterapi.service;

import com.marcoder.healthcenterapi.dto.DepartmentDTO;
import com.marcoder.healthcenterapi.dto.DepartmentUpdateDTO;
import com.marcoder.healthcenterapi.model.Department;

import java.util.List;

public interface IDepartmentService {

    List<DepartmentDTO> getDepartments();
    DepartmentDTO getDepartmentById(Long id);
    DepartmentDTO getDepartmentByName(String name);
    DepartmentDTO getDepartmentByBranchId(Long branchId);
    DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);
    String updateDepartmentById(DepartmentUpdateDTO departmentUpdateDTO,
                                       Long id);
    String deleteDepartment(Long id);
}
