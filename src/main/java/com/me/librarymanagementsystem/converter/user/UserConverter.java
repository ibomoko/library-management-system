package com.me.librarymanagementsystem.converter.user;


import com.me.librarymanagementsystem.entity.User;
import com.me.librarymanagementsystem.model.request.user.UserCreateRequest;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;

@Component
public class UserConverter implements Function<UserCreateRequest, User> {


    @Override
    public User apply(UserCreateRequest userCreateRequest) {
        return User.builder()
                .fullName(userCreateRequest.getFullname())
                .email(userCreateRequest.getEmail())
                .password(userCreateRequest.getPassword())
                .isDeleted(false)
                .createDate(new Date())
                .build();
    }
}
