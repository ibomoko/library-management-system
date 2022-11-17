package com.me.librarymanagementsystem.model.request.user;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class UserCreateRequest {

    @NotBlank(message = "Full name is mandatory")
    public String fullname;

    @NotBlank(message = "Password required")
    public String password;

    @NotBlank(message = "Email is mandatory")
    @Pattern(regexp = "[a-z\\d!#$%&'*+=?^_`{|}~-]+(?:\\.[a-z\\d!#$%&'*+=?^_`{|}~-]+)*@(?:[a-z\\d](?:[a-z\\d-]*[a-z\\d])?\\.)+[a-z\\d](?:[a-z\\d-]*[a-z\\d])?",
            message = "Email is invalid")
    public String email;
}
