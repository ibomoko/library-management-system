package com.me.librarymanagementsystem.converter.user;


import com.me.librarymanagementsystem.entity.User;
import com.me.librarymanagementsystem.model.response.user.UserCreateResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserResponseConverter implements Function<User, UserCreateResponse> {
    @Override
    public UserCreateResponse apply(User user) {
        return UserCreateResponse.builder()
                .id(user.getId())
                .createDate(user.getCreateDate())
                .email(user.getEmail())
                .fullName(user.getFullName())
                .build();

    }
}
