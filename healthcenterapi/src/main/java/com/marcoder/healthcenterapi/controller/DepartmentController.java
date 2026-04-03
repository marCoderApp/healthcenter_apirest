package com.marcoder.healthcenterapi.controller;

import com.marcoder.healthcenterapi.dto.DepartmentDTO;
import com.marcoder.healthcenterapi.dto.DepartmentUpdateDTO;
import com.marcoder.healthcenterapi.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    //GET DEPARTMENTS
    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getDepartments(){
        return ResponseEntity.ok(departmentService.getDepartments());
    }

    //GET DEPARTMENT BY ID
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable Long id){
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }

    //GET DEPARTMENT BY NAME
    @GetMapping("/name/{name}")
    public ResponseEntity<DepartmentDTO> getDepartmentByName(@PathVariable String name){
        return ResponseEntity.ok(departmentService.getDepartmentByName(name));
    }

    //GET DEPARTMENT BY BRANCH ID
    @GetMapping("/branch/{branch_id}")
    public ResponseEntity<DepartmentDTO> getDepartmentByBranchId(@PathVariable Long branch_id){
        return ResponseEntity.ok(departmentService.getDepartmentByBranchId(branch_id));
    }

    //SAVE DEPARTMENT
    @PostMapping("/save")
    public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO departmentDTO){
        return ResponseEntity.ok(departmentService.saveDepartment(departmentDTO));
    }

    //UPDATE DEPARTMENT BY ID
    @PatchMapping("/update/{id}")
    public ResponseEntity<String> updateDepartmentById(
            @RequestBody DepartmentUpdateDTO departmentUpdateDTO
    , @PathVariable Long id){
        return ResponseEntity.ok(departmentService.updateDepartmentById(departmentUpdateDTO, id));
    }

    //DELETE DEPARTMENT BY ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id){
        return ResponseEntity.ok(departmentService.deleteDepartment(id));
    }
}
