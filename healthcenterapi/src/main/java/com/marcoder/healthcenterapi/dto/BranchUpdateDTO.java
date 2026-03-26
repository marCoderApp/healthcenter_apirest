package com.marcoder.healthcenterapi.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BranchUpdateDTO {
    private String branch_name;
    private String address;
}
