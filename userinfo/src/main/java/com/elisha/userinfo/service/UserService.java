package com.elisha.userinfo.service;

import com.elisha.userinfo.dto.UserDTO;
import com.elisha.userinfo.entity.User;
import com.elisha.userinfo.mapper.UserMapper;
import com.elisha.userinfo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public UserDTO addUser(UserDTO userDTO) {
       User savedUser =  userRepo.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));
       return UserMapper.INSTANCE.mapUserToUserDTO(savedUser);
    }

    public ResponseEntity<UserDTO> fetchUserDetailsById(Integer userId) {
        Optional<User> fetchedUser =  userRepo.findById(userId);
        return fetchedUser.map(user -> new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(user), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.OK));

    }
}
