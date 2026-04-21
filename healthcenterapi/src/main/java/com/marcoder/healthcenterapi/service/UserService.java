package com.marcoder.healthcenterapi.service;

import com.marcoder.healthcenterapi.dto.ChangePasswordDTO;
import com.marcoder.healthcenterapi.dto.RegisterUserDTO;
import com.marcoder.healthcenterapi.dto.UpdateUserDTO;
import com.marcoder.healthcenterapi.dto.UserDTO;
import com.marcoder.healthcenterapi.enums.UserRole;
import com.marcoder.healthcenterapi.exception.NotFoundException;
import com.marcoder.healthcenterapi.mapper.Mapper;
import com.marcoder.healthcenterapi.model.User;
import com.marcoder.healthcenterapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    //GET ALL USERS
    @Override
    public List<UserDTO> getAllUsers(){
        return userRepository.findAll().stream()
                .map(Mapper::userToDTO)
                .toList();
    }

    //GET USER BY ID
    @Override
    public UserDTO getUserById(Long id){
        return Mapper.userToDTO(userRepository.findById(id).orElseThrow());
    }

    //GET USER BY EMAIL
    @Override
    public UserDTO getUserByEmail(String email){
        return Mapper.userToDTO(userRepository.findByEmail(email).orElseThrow());
    }

    //SAVE USER
    @Override
    public UserDTO createUser(RegisterUserDTO registerUserDTO){

        User user = userRepository.findByEmail(registerUserDTO.getEmail()).orElse(null);

        if (user != null){
            throw new RuntimeException("User already exists");
        }

            User newUser = Mapper.dtoToUserEntity(registerUserDTO);

            String password = passwordEncoder.encode(registerUserDTO.getPassword());

            newUser.setPassword(password);

            User savedUser = userRepository.save(newUser);

            return Mapper.userToDTO(savedUser);
    }

    //UPDATE USER BY ID
    @Override
    public UserDTO updateUser(UpdateUserDTO updateUserDTO,
                              Long id){
        User user = userRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("User not found with id: " + id)
        );

        if(user.getEmail().equals(updateUserDTO.getEmail())){
            throw new RuntimeException("Email already exists");
        }

        user.setUsername(updateUserDTO.getUsername());
        user.setEmail(updateUserDTO.getEmail());
        user.setName(updateUserDTO.getName());
        user.setLastname(updateUserDTO.getLastname());
        user.setAddress(updateUserDTO.getAddress());
        user.setPhone(updateUserDTO.getPhone());
        user.setRole(UserRole.valueOf(updateUserDTO.getRole()));
        user.setNational_id_number(updateUserDTO.getNational_id_number());

        User savedUser = userRepository.save(user);

        return Mapper.userToDTO(savedUser);
    }

    //CHANGE PASSWORD
    @Override
    public String changePassword(ChangePasswordDTO changePasswordDTO,
                                 Long id){
       User user = userRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("User not found with id: " + id)
        );

       if(!passwordEncoder.matches(changePasswordDTO.getCurrent_password(), user.getPassword())){
           throw new RuntimeException("Current password is incorrect");
       }

       String encodedNewPassword = passwordEncoder.encode(changePasswordDTO.getNew_password());
       user.setPassword(encodedNewPassword);
       userRepository.save(user);
       return "Password changed successfully";
    }

    //DELETE USER BY ID
    @Override
    public String deleteUser(Long id){
        User user = userRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("User not found with id: " + id)
        );

        userRepository.delete(user);
        return "User deleted successfully";

    }
}
