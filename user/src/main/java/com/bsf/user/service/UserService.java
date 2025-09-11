package com.bsf.user.service;

import com.bsf.user.domain.UserModel;
import com.bsf.user.dto.UserDTO;
import com.bsf.user.mapper.UserMapper;
import com.bsf.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserDTO saveUser(UserDTO userDTO) {
        UserModel userModel = UserMapper.toEntity(userDTO);
        UserModel savedUser = userRepository.save(userModel);
        return UserMapper.toDto(savedUser);
    }

    public List<UserDTO> getAllUsers() {
        List<UserModel> users = userRepository.findAll();
        return users.stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }



}
