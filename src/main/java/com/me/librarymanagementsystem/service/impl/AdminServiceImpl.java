package com.me.librarymanagementsystem.service.impl;

import com.me.librarymanagementsystem.converter.admin.AdminConverter;
import com.me.librarymanagementsystem.converter.admin.AdminResponseConverter;
import com.me.librarymanagementsystem.entity.Admin;
import com.me.librarymanagementsystem.error.exception.ResourceAlreadyExistException;
import com.me.librarymanagementsystem.error.exception.ResourceNotFoundException;
import com.me.librarymanagementsystem.model.request.admin.AdminCreateRequest;
import com.me.librarymanagementsystem.model.response.admin.AdminCreateResponse;
import com.me.librarymanagementsystem.repository.AdminRepository;
import com.me.librarymanagementsystem.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
        private final AdminConverter adminConverter;
        private final AdminRepository adminRepository;
        private final PasswordEncoder passwordEncoder;

        private final AdminResponseConverter adminResponseConverter;

    @Override
    public AdminCreateResponse createAdmin(AdminCreateRequest adminCreateRequest) {

        adminRepository.findByEmailAndIsDeletedFalse(adminCreateRequest.getEmail()).ifPresent(admin ->
        {throw new ResourceAlreadyExistException();
        });

        Admin admin =adminConverter.apply(adminCreateRequest);

        admin.setPassword(passwordEncoder.encode(admin.getPassword()));

        adminRepository.save(admin);

        return  adminResponseConverter.apply(admin);
    }

    @Override
    public List<AdminCreateResponse> getAllAdmins() {
        return adminRepository.findAll().stream().map(adminResponseConverter).toList();
    }

    @Override
    public Admin getAdminByEmail(String email) {
        return adminRepository.findByEmailAndIsDeletedFalse(email).orElseThrow(() ->
                new ResourceNotFoundException("Admin not found"));
    }

    @Override
    public void delete(Long id) {
        adminRepository.deleteById(id);
    }
}
