package com.marcoder.healthcenterapi.service;

import com.marcoder.healthcenterapi.dto.DepartmentDTO;
import com.marcoder.healthcenterapi.dto.DepartmentUpdateDTO;
import com.marcoder.healthcenterapi.exception.NotFoundException;
import com.marcoder.healthcenterapi.mapper.Mapper;
import com.marcoder.healthcenterapi.model.Branch;
import com.marcoder.healthcenterapi.model.Department;
import com.marcoder.healthcenterapi.repository.BranchRepository;
import com.marcoder.healthcenterapi.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {


    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    BranchRepository branchRepository;

    //GET DEPARTMENTS
    @Override
    public List<DepartmentDTO> getDepartments(){
    return departmentRepository.findAll()
            .stream()
            .map(Mapper::departmentToDTO)
            .toList();
    }

    //GET DEPARTMENT BY ID
    @Override
    public DepartmentDTO getDepartmentById(Long id){
        return Mapper.departmentToDTO(departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + id)));
    }

    //GET DEPARTMENT BY NAME
    @Override
    public DepartmentDTO getDepartmentByName(String name){
        return Mapper.departmentToDTO(departmentRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Department not found with name: " + name)));
    }

    //GET DEPARTMENT BY BRANCH ID
    @Override
    public DepartmentDTO getDepartmentByBranchId(Long branch_id){
        return Mapper.departmentToDTO(departmentRepository.findByBranchId(branch_id)
                .orElseThrow(()-> new NotFoundException("Department" +
                        " not found with branch_id: "
                        + branch_id)));
    }

    //SAVE DEPARTMENT
    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO){
        if(departmentDTO == null){
            return null;
        }

        if (departmentDTO.getBranch_id() == null || departmentDTO.getBranch_id().isBlank()) {
            throw new IllegalArgumentException("Branch id is required");
        }

        Branch branch = branchRepository.findById(Long.parseLong(departmentDTO.getBranch_id()))
                .orElseThrow(() -> new NotFoundException("Branch not found with id: " + departmentDTO.getBranch_id()));

        Department department = Department.builder()
                .name(departmentDTO.getName())
                .branch(branch)
                .build();

        Department savedDepartment = departmentRepository.save(department);
        return Mapper.departmentToDTO(savedDepartment);
    }

    //UPDATE DEPARTMENT
    @Override
    public String updateDepartmentById(DepartmentUpdateDTO departmentUpdateDTO
    , Long id){
        if(departmentUpdateDTO == null){
            return "Wrong input!";
        }

        Department department = departmentRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Department not found with id: " + id)
        );

        department.setName(departmentUpdateDTO.getName());
        departmentRepository.save(department);
        return "Department updated successfully";
    }

    //DELETE DEPARTMENT
    @Override
    public String deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
        return "Department deleted successfully";
    }

}
