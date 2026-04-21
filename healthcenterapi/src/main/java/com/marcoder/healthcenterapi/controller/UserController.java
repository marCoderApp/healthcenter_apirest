package com.marcoder.healthcenterapi.controller;

import com.marcoder.healthcenterapi.dto.ChangePasswordDTO;
import com.marcoder.healthcenterapi.dto.RegisterUserDTO;
import com.marcoder.healthcenterapi.dto.UpdateUserDTO;
import com.marcoder.healthcenterapi.dto.UserDTO;
import com.marcoder.healthcenterapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //GET ALL USERS
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    //GET USER BY ID
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    //GET USER BY EMAIL
    @GetMapping("/email/{email}")
    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable String email){
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

    //CREATE USER
    @PostMapping("/save")
    public ResponseEntity<UserDTO> createUser(@RequestBody RegisterUserDTO registerUserDTO){
        return ResponseEntity.ok(userService.createUser(registerUserDTO));
    }

    //UPDATE USER BY ID
    @PatchMapping("/update/{id}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UpdateUserDTO updateUserDTO, @PathVariable Long id){
        return ResponseEntity.ok(userService.updateUser(updateUserDTO, id));
    }

    //CHANGE PASSWORD
    @PatchMapping("/update-password/{id}")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO,
                                                 @PathVariable Long id){
        return ResponseEntity.ok(userService.changePassword(changePasswordDTO, id));
    }

    //DELETE USER BY ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.deleteUser(id));
    }

}
