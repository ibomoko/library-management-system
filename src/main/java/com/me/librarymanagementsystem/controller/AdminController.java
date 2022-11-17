package com.me.librarymanagementsystem.controller;


import com.me.librarymanagementsystem.entity.Admin;
import com.me.librarymanagementsystem.model.request.admin.AdminCreateRequest;
import com.me.librarymanagementsystem.model.response.admin.AdminCreateResponse;
import com.me.librarymanagementsystem.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RequestMapping("api/admin")
@RestController
@RequiredArgsConstructor
public class AdminController {

  private final  AdminService adminService;

    @PostMapping
    public ResponseEntity<AdminCreateResponse> createAdmin(@RequestBody @Valid AdminCreateRequest adminCreateRequest){
        return ResponseEntity.ok(adminService.createAdmin(adminCreateRequest));
    }

    @GetMapping("/getAdmins")
    public ResponseEntity<List<AdminCreateResponse>>  getAdmins(){
        return ResponseEntity.ok(adminService.getAllAdmins());
    }

    @GetMapping("/getAdminByEmail")
    public Admin getAdminByEmail( @RequestParam String email){
      return adminService.getAdminByEmail(email);
    }

    @DeleteMapping("/deleteById{id}")
      public void delete(@PathVariable Long id){
      adminService.delete(id);
    }


}
