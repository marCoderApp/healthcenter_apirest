package com.marcoder.healthcenterapi.service;

import com.marcoder.healthcenterapi.dto.BranchDTO;
import com.marcoder.healthcenterapi.dto.BranchUpdateDTO;

import java.util.List;

public interface IBranchService {

    List<BranchDTO> getBranches();
    BranchDTO getBranchById(Long id);
    BranchDTO saveBranch(BranchDTO branchDTO);
    String updateBranchById(BranchDTO branchDTO, Long id);
    String updateBranchByIdPartial(BranchUpdateDTO branchUpdateDTO, Long id);
    String deleteBranch(Long id);

}
