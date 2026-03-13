package com.marcoder.healthcenterapi.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BranchDTO {

    private Long id;
    private String branch_name;
    private String address;

}
