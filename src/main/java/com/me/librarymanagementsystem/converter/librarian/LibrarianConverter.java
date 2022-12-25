package com.me.librarymanagementsystem.converter.librarian;


import com.me.librarymanagementsystem.entity.Admin;
import com.me.librarymanagementsystem.entity.Librarian;
import com.me.librarymanagementsystem.model.request.admin.AdminCreateRequest;
import com.me.librarymanagementsystem.model.request.librarian.LibrarianCreateRequest;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;

@Component
public class LibrarianConverter implements Function<LibrarianCreateRequest, Librarian> {

    @Override
    public Librarian apply(LibrarianCreateRequest librarianCreateRequest) {
        return Librarian.builder()
                .fullName(librarianCreateRequest.getFullname())
                .email(librarianCreateRequest.getEmail())
                .password(librarianCreateRequest.getPassword())
                .createDate(new Date())
                .isDeleted(false)
                .build();

    }

}
