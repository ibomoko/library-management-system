package com.me.librarymanagementsystem.service;


import com.me.librarymanagementsystem.entity.Admin;
import com.me.librarymanagementsystem.model.request.admin.AdminCreateRequest;
import com.me.librarymanagementsystem.model.response.admin.AdminCreateResponse;

import java.util.List;

public interface AdminService {

        AdminCreateResponse createAdmin(AdminCreateRequest adminCreateRequest);

        List<AdminCreateResponse> getAllAdmins();

        Admin getAdminByEmail(String email);
        void delete(Long id);
        void checkAdminCredentials(String email,String password);

}
