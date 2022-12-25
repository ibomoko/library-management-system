package com.me.librarymanagementsystem.service;

import com.me.librarymanagementsystem.entity.Librarian;
import com.me.librarymanagementsystem.model.request.librarian.LibrarianCreateRequest;
import com.me.librarymanagementsystem.model.response.librarian.LibrarianCreateResponse;

public interface LibrarianService {
    void checkLibrarianCredentials(String email, String password);
    Librarian getLibrarianByEmail(String email);
    LibrarianCreateResponse createLibrarian(LibrarianCreateRequest librarianCreateRequest);

}
