package com.me.librarymanagementsystem.converter.librarian;

import com.me.librarymanagementsystem.entity.Admin;
import com.me.librarymanagementsystem.entity.Librarian;
import com.me.librarymanagementsystem.model.response.admin.AdminCreateResponse;
import com.me.librarymanagementsystem.model.response.librarian.LibrarianCreateResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class LibrarianResponseConverter implements Function<Librarian,LibrarianCreateResponse> {

    @Override
    public LibrarianCreateResponse apply(Librarian librarian) {
        return LibrarianCreateResponse.builder()
                .id(librarian.getId())
                .createDate(librarian.getCreateDate())
                .email(librarian.getEmail())
                .fullName(librarian.getFullName())
                .build();
    }
}
