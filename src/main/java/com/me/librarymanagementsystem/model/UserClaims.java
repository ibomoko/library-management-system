package com.me.librarymanagementsystem.model;

import com.me.librarymanagementsystem.enums.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserClaims {
    private String email;
    private Role role;
}
