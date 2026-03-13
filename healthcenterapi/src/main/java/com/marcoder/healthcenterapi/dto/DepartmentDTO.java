package com.marcoder.healthcenterapi.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentDTO {

    private Long department_id;
    private String name;
    private String branch_id;

}
