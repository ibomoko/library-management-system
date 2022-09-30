package com.me.librarymanagementsystem.controller;


import com.me.librarymanagementsystem.entity.Admin;
import com.me.librarymanagementsystem.model.request.admin.AdminCreateRequest;
import com.me.librarymanagementsystem.model.response.AdminCreateResponse;
import com.me.librarymanagementsystem.service.AdminService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RequestMapping("api")
@RestController
@RequiredArgsConstructor
public class AdminController {

  private final  AdminService adminService;

    @PostMapping
    public ResponseEntity<AdminCreateResponse> createAdmin(@RequestBody @Valid AdminCreateRequest adminCreateRequest){
        return ResponseEntity.ok(adminService.createAdmin(adminCreateRequest));
    }

    @GetMapping("/admins")
    public ResponseEntity<List<AdminCreateResponse>>  getAdmins(){
        return ResponseEntity.ok(adminService.getAllAdmins());
    }


}
