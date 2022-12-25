package com.me.librarymanagementsystem.service;

import com.me.librarymanagementsystem.enums.Role;
import com.me.librarymanagementsystem.model.UserCredentials;
import com.me.librarymanagementsystem.model.request.auth.LoginRequest;
import com.me.librarymanagementsystem.model.response.auth.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    UserCredentials  checkUserExisting(String email, Role role);

}
