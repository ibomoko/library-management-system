package com.me.librarymanagementsystem.controller;


import com.me.librarymanagementsystem.entity.User;
import com.me.librarymanagementsystem.model.request.admin.AdminCreateRequest;
import com.me.librarymanagementsystem.model.request.user.UserCreateRequest;
import com.me.librarymanagementsystem.model.response.admin.AdminCreateResponse;
import com.me.librarymanagementsystem.model.response.user.UserCreateResponse;
import com.me.librarymanagementsystem.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;


     @PostMapping("/createUser")
     public ResponseEntity<UserCreateResponse> createUser(@RequestBody @Valid UserCreateRequest userCreateRequest) {
         return ResponseEntity.ok(userService.createUser(userCreateRequest));
     }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserCreateResponse>> getAllUsers () {
    return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/getUserById")
    public ResponseEntity<User> getUserById(@RequestParam Long id){
         return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/getUserByEmail")
    public ResponseEntity<User> getUserByEmail(@RequestParam String email){
         return ResponseEntity.ok(userService.getUserByEmail(email));
    }

    @DeleteMapping("/deleteById/{id}")
    @Transactional
    public void deleteUserById(@PathVariable Long id){
         userService.delete(id);
    }

}
