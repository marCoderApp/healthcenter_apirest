package com.marcoder.healthcenterapi.service;

import com.marcoder.healthcenterapi.dto.SpecialltyDTO;

import java.util.List;

public interface ISpecialltyService {

    List<SpecialltyDTO> getSpeciallties();
    SpecialltyDTO getSpecialltyById(Long id);
    SpecialltyDTO getSpecialltiesByName(String name);
    SpecialltyDTO saveSpeciallty(SpecialltyDTO specialltyDTO);
    String updateSpecialltyById(SpecialltyDTO specialltyDTO, Long id);
    String deleteSpeciallty(Long id);
}
