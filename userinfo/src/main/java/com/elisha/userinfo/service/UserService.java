package com.elisha.userinfo.service;

import com.elisha.userinfo.dto.UserDTO;
import com.elisha.userinfo.entity.User;
import com.elisha.userinfo.mapper.UserMapper;
import com.elisha.userinfo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public UserDTO addUser(UserDTO userDTO) {
       User savedUser =  userRepo.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));
       return UserMapper.INSTANCE.mapUserToUserDTO(savedUser);
    }
}
