package com.marcoder.healthcenterapi.service;

import com.marcoder.healthcenterapi.dto.SpecialltyDTO;
import com.marcoder.healthcenterapi.exception.NotFoundException;
import com.marcoder.healthcenterapi.mapper.Mapper;
import com.marcoder.healthcenterapi.model.Speciallty;
import com.marcoder.healthcenterapi.repository.SpecialltyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialltyService implements ISpecialltyService {

    @Autowired
    private SpecialltyRepository specialltyRepository;

    //GET ALL SPECIALLTIES
    @Override
    public List<SpecialltyDTO> getSpeciallties(){
        return specialltyRepository.findAll()
                .stream()
                .map(Mapper::specialtyToDTO)
                .toList();
    }

    //GET SPECIALLTY BY ID
    @Override
    public SpecialltyDTO getSpecialltyById(Long id){
        return Mapper.specialtyToDTO(specialltyRepository.findBySpeciallty_Id(id));
    }

    //GET SPECIALLTY BY NAME
    @Override
    public SpecialltyDTO getSpecialltiesByName(String name){
        Speciallty speciallty = specialltyRepository.findByName(name);

        if (speciallty == null){
            throw new NotFoundException("Speciallty not found with name: " + name);
        }

        return Mapper.specialtyToDTO(speciallty);
    }

    //SAVE SPECIALLTY
    @Override
    public SpecialltyDTO saveSpeciallty(SpecialltyDTO specialltyDTO){
        if(specialltyDTO == null){
            return null;
        }

        Speciallty speciallty = Speciallty.builder()
                .name(specialltyDTO.getName())
                .build();

       Speciallty savedSpeciallty = specialltyRepository.save(speciallty);
        return Mapper.specialtyToDTO(savedSpeciallty);
    }

    //UPDATE SPECIALLTY BY ID
    @Override
    public String updateSpecialltyById(SpecialltyDTO specialltyDTO, Long id){
        if (specialltyDTO == null){
            return "Wrong input!";
        }

        Speciallty speciallty = specialltyRepository.findBySpeciallty_Id(id);

        if (speciallty == null){
            throw new NotFoundException("Speciallty not found with id: " + id);
        }

        speciallty.setName(specialltyDTO.getName());
        specialltyRepository.save(speciallty);
        return "Speciallty updated successfully";
    }

    //DELETE SPECIALLTY BY ID
    @Override
    public String deleteSpeciallty(Long id){
        specialltyRepository.deleteById(id);
        return "Speciallty deleted successfully";
    }

}
