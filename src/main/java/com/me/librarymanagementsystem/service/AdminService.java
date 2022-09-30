package com.me.librarymanagementsystem.service;


import com.me.librarymanagementsystem.entity.Admin;
import com.me.librarymanagementsystem.model.request.admin.AdminCreateRequest;
import com.me.librarymanagementsystem.model.response.AdminCreateResponse;

import java.util.List;

public interface AdminService {

        AdminCreateResponse createAdmin(AdminCreateRequest adminCreateRequest);

        List<AdminCreateResponse> getAllAdmins();

        AdminCreateResponse getAdminByEmail(String email);

}
