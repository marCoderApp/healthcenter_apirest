package com.marcoder.healthcenterapi.controller;

import com.marcoder.healthcenterapi.dto.SpecialltyDTO;
import com.marcoder.healthcenterapi.service.SpecialltyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/speciallty")
public class SpecialltyController {

    @Autowired
    private SpecialltyService specialltyService;

    //GET SPECIALLTIES
    @GetMapping
    public ResponseEntity<List<SpecialltyDTO>> getSpeciallties(){
        return ResponseEntity.ok(specialltyService.getSpeciallties());
    }

    //GET SPECIALLTY BY ID
    @GetMapping("/{id}")
    public ResponseEntity<SpecialltyDTO> getSpecialltyById(@PathVariable Long id){
        return ResponseEntity.ok(specialltyService.getSpecialltyById(id));
    }

    //GET SPECIALLTY BY NAME
    @GetMapping("/name/{name}")
    public ResponseEntity<SpecialltyDTO> getSpecialltiesByName(@PathVariable String name){
        return ResponseEntity.ok(specialltyService.getSpecialltiesByName(name));
    }

    //SAVE SPECIALLTY
    @PostMapping
    public ResponseEntity<SpecialltyDTO> saveSpeciallty(@RequestBody SpecialltyDTO specialltyDTO){
        return ResponseEntity.ok(specialltyService.saveSpeciallty(specialltyDTO));
    }

    //UPDATE SPECIALLTY BY ID
    @PatchMapping("/update/{id}")
    public ResponseEntity<String> updateSpecialltyById(
            @RequestBody SpecialltyDTO specialltyDTO,
            @PathVariable Long id
    ){
        return ResponseEntity.ok(specialltyService.updateSpecialltyById(specialltyDTO, id));
    }

    //DELETE SPECIALLTY BY ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSpeciallty(@PathVariable Long id){
        return ResponseEntity.ok(specialltyService.deleteSpeciallty(id));
    }
}
