package com.me.librarymanagementsystem.service.impl;

import com.me.librarymanagementsystem.entity.Admin;
import com.me.librarymanagementsystem.entity.Librarian;
import com.me.librarymanagementsystem.entity.User;
import com.me.librarymanagementsystem.enums.Role;
import com.me.librarymanagementsystem.model.UserCredentials;
import com.me.librarymanagementsystem.model.request.auth.LoginRequest;
import com.me.librarymanagementsystem.model.response.auth.LoginResponse;
import com.me.librarymanagementsystem.security.JWTProvider;
import com.me.librarymanagementsystem.service.AdminService;
import com.me.librarymanagementsystem.service.AuthService;
import com.me.librarymanagementsystem.service.LibrarianService;
import com.me.librarymanagementsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserService userService;
    private final AdminService adminService;
    private final LibrarianService librarianService;
    private final JWTProvider jwtProvider;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
       checkLoginCredentials(loginRequest);
      String token =jwtProvider.generateToken(loginRequest.getEmail(), loginRequest.getRole());
      return  new LoginResponse(token);
    }

    @Override
    public UserCredentials checkUserExisting(String email, Role role) {
        return checkExisting(email, role);
    }


    public UserCredentials checkExisting(String email, Role role) {
        return switch(role){
            case USER -> convertToUserCredentials(userService.getUserByEmail(email));
            case ADMIN -> convertToUserCredentials(adminService.getAdminByEmail(email));
            case LIBRARIAN -> convertToUserCredentials(librarianService.getLibrarianByEmail(email));
        };
    }
    public UserCredentials convertToUserCredentials(User user){
    return  new UserCredentials(user.getEmail(), user.getPassword());
    }

    public UserCredentials convertToUserCredentials(Admin admin){
        return  new UserCredentials(admin.getEmail(), admin.getPassword());
    }
    public UserCredentials convertToUserCredentials(Librarian librarian){
        return  new UserCredentials(librarian.getEmail(), librarian.getPassword());
    }

    private void checkLoginCredentials(LoginRequest loginRequest){
        switch(loginRequest.getRole()){
            case ADMIN -> adminService.checkAdminCredentials(loginRequest.getEmail(), loginRequest.getPassword());
            case USER -> userService.checkUserCredentials(loginRequest.getEmail(), loginRequest.getPassword());
            case LIBRARIAN -> librarianService.checkLibrarianCredentials(loginRequest.getEmail(), loginRequest.getPassword());
        }

    }
}
