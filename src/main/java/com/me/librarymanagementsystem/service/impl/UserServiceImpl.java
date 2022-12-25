package com.me.librarymanagementsystem.service.impl;

import com.me.librarymanagementsystem.config.PasswordEncoderConfig;
import com.me.librarymanagementsystem.converter.user.UserConverter;
import com.me.librarymanagementsystem.converter.user.UserResponseConverter;
import com.me.librarymanagementsystem.entity.User;
import com.me.librarymanagementsystem.error.exception.ResourceAlreadyExistException;
import com.me.librarymanagementsystem.error.exception.ResourceNotFoundException;
import com.me.librarymanagementsystem.model.request.user.UserCreateRequest;
import com.me.librarymanagementsystem.model.response.user.UserCreateResponse;
import com.me.librarymanagementsystem.repository.UserRepository;
import com.me.librarymanagementsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserConverter userConverter;
    private final UserResponseConverter userResponseConverter;
    private final PasswordEncoderConfig passwordEncoderConfig;

    @Override
    public UserCreateResponse createUser(UserCreateRequest userCreateRequest) {
        userRepository.findByEmail(userCreateRequest.getEmail())
                .ifPresent(user->{ throw new ResourceAlreadyExistException();});

        User user = userConverter.apply(userCreateRequest);
        user.setPassword(passwordEncoder.encode(userCreateRequest.getPassword()));
        userRepository.save(user);
        return userResponseConverter.apply(user);
    }

    @Override
    public List<UserCreateResponse> getAllUsers() {
        return userRepository.findAll().stream().map(userResponseConverter).toList();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with this id"));
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email).orElseThrow(()-> new ResourceNotFoundException("User not found with this email"));
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteUserById(id);
    }


}
