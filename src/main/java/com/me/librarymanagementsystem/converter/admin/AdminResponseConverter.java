package com.me.librarymanagementsystem.converter.admin;

import com.me.librarymanagementsystem.entity.Admin;
import com.me.librarymanagementsystem.model.response.admin.AdminCreateResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AdminResponseConverter implements Function<Admin, AdminCreateResponse> {
    @Override
    public AdminCreateResponse apply(Admin admin) {
        return AdminCreateResponse.builder()
                .id(admin.getId())
                .createDate(admin.getCreateDate())
                .email(admin.getEmail())
                .fullName(admin.getFullName())
                .build();

    }
}
