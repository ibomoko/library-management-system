package com.me.librarymanagementsystem.model.request.librarian;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class LibrarianCreateRequest {
    @NotBlank(message = "Full name is mandatory")
    public String fullname;

    @NotBlank(message = "Password required")
    @Size(min = 8,message = "Password must be greater than or equal to 8 characters.")
    public String password;

    @NotBlank(message = "Email is mandatory")
    @Pattern(regexp = "[a-z\\d!#$%&'*+=?^_`{|}~-]+(?:\\.[a-z\\d!#$%&'*+=?^_`{|}~-]+)*@(?:[a-z\\d](?:[a-z\\d-]*[a-z\\d])?\\.)+[a-z\\d](?:[a-z\\d-]*[a-z\\d])?",
            message = "Email is invalid")
    public String email;
}
