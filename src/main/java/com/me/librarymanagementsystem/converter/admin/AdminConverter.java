package com.me.librarymanagementsystem.converter.admin;

import com.me.librarymanagementsystem.entity.Admin;
import com.me.librarymanagementsystem.model.request.admin.AdminCreateRequest;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;


@Component
public class AdminConverter implements Function<AdminCreateRequest, Admin> {

    @Override
    public Admin apply(AdminCreateRequest adminCreateRequest) {
        return Admin.builder()
                .fullName(adminCreateRequest.getFullName())
                .email(adminCreateRequest.getEmail())
                .password(adminCreateRequest.getPassword())
                .createDate(new Date())
                .isDeleted(false)
                .build();

    }
}
