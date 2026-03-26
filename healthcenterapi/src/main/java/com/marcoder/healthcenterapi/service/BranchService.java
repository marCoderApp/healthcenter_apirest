package com.marcoder.healthcenterapi.service;

import com.marcoder.healthcenterapi.dto.BranchDTO;
import com.marcoder.healthcenterapi.dto.BranchUpdateDTO;
import com.marcoder.healthcenterapi.exception.NotFoundException;
import com.marcoder.healthcenterapi.mapper.Mapper;
import com.marcoder.healthcenterapi.model.Branch;
import com.marcoder.healthcenterapi.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService implements IBranchService {

    @Autowired
    BranchRepository branchRepository;

    //GET BRANCHES
   @Override
    public List<BranchDTO> getBranches(){
    return branchRepository.findAll()
            .stream()
            .map(Mapper::branchToDTO)
            .toList();
   }

   //GET BRANCH BY ID
   @Override
    public BranchDTO getBranchById(Long id){
    return Mapper.branchToDTO(branchRepository.findById(id)
    .orElseThrow(() -> new NotFoundException("Branch not found with id: " + id)));
   }

   //SAVE BRANCH
    @Override
    public BranchDTO saveBranch(BranchDTO branchDTO){
       if(branchDTO == null){
           return null;
       }

       Branch branch = Branch.builder()
               .name(branchDTO.getBranch_name())
               .address(branchDTO.getAddress())
               .build();

       Branch savedBranch = branchRepository.save(branch);
       return Mapper.branchToDTO(savedBranch);
    }

    //UPDATE BRANCH BY ID
    @Override
    public String updateBranchById(BranchDTO branchDTO, Long id) {
        if(branchDTO == null || id == null){
            return "Branch not found";
        }

        Branch branch = branchRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Branch not found with id: " + id));
        branch.setName(branchDTO.getBranch_name());
        branch.setAddress(branchDTO.getAddress());

        branchRepository.save(branch);
        return "Branch updated successfully";
    }

    //UPDATE BRANCH BY ID (PARTIAL)
    @Override
    public String updateBranchByIdPartial(BranchUpdateDTO branchUpdateDTO,
                                          Long id) {
       if(branchUpdateDTO == null || id == null){
           return "Wrong imput!";
       }

       Branch branch = branchRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Branch not found with id: " + id));

       branch.setName(branchUpdateDTO.getBranch_name());
       branch.setAddress(branchUpdateDTO.getAddress());

       branchRepository.save(branch);
       return "Branch updated successfully";

    }

    //DELETE BRANCH BY ID
    @Override
    public String deleteBranch(Long id){
       if(id == null){
           return "Wrong id";
       }
       branchRepository.deleteById(id);
       return "Branch deleted successfully";
    }

}
