package com.marcoder.healthcenterapi.controller;

import com.marcoder.healthcenterapi.dto.BranchDTO;
import com.marcoder.healthcenterapi.dto.BranchUpdateDTO;
import com.marcoder.healthcenterapi.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    BranchService branchService;

    //GET BRANCHES
    @GetMapping
    public ResponseEntity<List<BranchDTO>> getBranches(){
        return ResponseEntity.ok(branchService.getBranches());
    }

    //GET BRANCH BY ID
    @GetMapping("/{id}")
    public ResponseEntity<BranchDTO> getBranchById(@PathVariable Long id){
        return ResponseEntity.ok(branchService.getBranchById(id));
    }

    //SAVE BRANCH
    @PostMapping("/save")
    public ResponseEntity<BranchDTO> saveBranch(@RequestBody BranchDTO branchDTO){
        return ResponseEntity.ok(branchService.saveBranch(branchDTO));
    }

    //UPDATE BRANCH BY ID (COMPLETE)
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateBranchById(@RequestBody BranchDTO branchDTO, @PathVariable Long id){
        return ResponseEntity.ok(branchService.updateBranchById(branchDTO, id));
    }

    //UPDATE BRANCH BY ID (PARTIAL)
    @PatchMapping("/update/custom/{id}")
    public ResponseEntity<String> updateBranchByIdPartial(
            @RequestBody BranchUpdateDTO branchUpdateDTO,
            @PathVariable Long id){

        return ResponseEntity.ok(branchService.updateBranchByIdPartial(branchUpdateDTO, id));
    }

    //DELETE BRANCH BY ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBranch(@PathVariable Long id){
        return ResponseEntity.ok(branchService.deleteBranch(id));
    }
}
