package com.marcoder.healthcenterapi.mapper;


import com.marcoder.healthcenterapi.dto.BranchDTO;
import com.marcoder.healthcenterapi.model.Branch;

public class Mapper {

    public static BranchDTO branchToDTO(Branch branch){
        if(branch == null) return null;

        BranchDTO branchDTO = BranchDTO.builder()
                .id(branch.getBranch_id())
                .branch_name(branch.getName())
                .address(branch.getAddress())
                .build();

        return branchDTO;
    }

}
