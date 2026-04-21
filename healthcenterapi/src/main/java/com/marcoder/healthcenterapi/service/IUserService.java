package com.marcoder.healthcenterapi.service;

import com.marcoder.healthcenterapi.dto.ChangePasswordDTO;
import com.marcoder.healthcenterapi.dto.RegisterUserDTO;
import com.marcoder.healthcenterapi.dto.UpdateUserDTO;
import com.marcoder.healthcenterapi.dto.UserDTO;

import java.util.List;

public interface IUserService {

    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    UserDTO getUserByEmail(String email);
    UserDTO createUser(RegisterUserDTO registerUserDTO);
    UserDTO updateUser(UpdateUserDTO updateUserDTO, Long id);
    String changePassword(ChangePasswordDTO changePasswordDTO, Long id);
    String deleteUser(Long id);

}
