package com.me.librarymanagementsystem.service;

import com.me.librarymanagementsystem.entity.User;
import com.me.librarymanagementsystem.model.request.user.UserCreateRequest;
import com.me.librarymanagementsystem.model.response.user.UserCreateResponse;

import java.util.List;

public interface UserService {
    UserCreateResponse createUser(UserCreateRequest userCreateRequest);
    List<UserCreateResponse> getAllUsers();
    User getUserById(Long id);
    User getUserByEmail(String email);




}
