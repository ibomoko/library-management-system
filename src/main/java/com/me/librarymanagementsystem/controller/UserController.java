package com.me.librarymanagementsystem.controller;


import com.me.librarymanagementsystem.entity.User;
import com.me.librarymanagementsystem.model.request.user.UserCreateRequest;
import com.me.librarymanagementsystem.model.response.user.UserCreateResponse;
import com.me.librarymanagementsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/api/users")
public class UserController {
    private final UserService userService;


     @PostMapping
     public ResponseEntity<UserCreateResponse> createUser(@RequestBody @Valid UserCreateRequest userCreateRequest) {
         return ResponseEntity.ok(userService.createUser(userCreateRequest));
     }

    @GetMapping
    public ResponseEntity<List<UserCreateResponse>> getAllUsers () {
    return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
         return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email){
         return ResponseEntity.ok(userService.getUserByEmail(email));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteUserById(@PathVariable Long id){
         userService.delete(id);
    }

}
