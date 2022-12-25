package com.me.librarymanagementsystem.service.impl;

import com.me.librarymanagementsystem.converter.librarian.LibrarianConverter;
import com.me.librarymanagementsystem.converter.librarian.LibrarianResponseConverter;
import com.me.librarymanagementsystem.entity.Admin;
import com.me.librarymanagementsystem.entity.Librarian;
import com.me.librarymanagementsystem.enums.Role;
import com.me.librarymanagementsystem.error.exception.ResourceAlreadyExistException;
import com.me.librarymanagementsystem.error.exception.ResourceNotFoundException;
import com.me.librarymanagementsystem.model.request.librarian.LibrarianCreateRequest;
import com.me.librarymanagementsystem.model.response.librarian.LibrarianCreateResponse;
import com.me.librarymanagementsystem.repository.LibrarianRepository;
import com.me.librarymanagementsystem.service.LibrarianService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LibrarianServiceImpl implements LibrarianService {

    private final LibrarianRepository librarianRepository;
    private final PasswordEncoder passwordEncoder;
    private final LibrarianConverter librarianConverter;
    private final LibrarianResponseConverter librarianResponseConverter;

    @Override
    public void checkLibrarianCredentials(String email, String password) {
        Librarian librarian =librarianRepository.findByEmailAndIsDeletedFalse(email)
                .orElseThrow(()->new ResourceNotFoundException("Resource not found with this email"));

        if(passwordEncoder.matches(password, librarian.getPassword())){
            return;
        }
        throw new RuntimeException(("Password is invalid"));
    }

    @Override
    public Librarian getLibrarianByEmail(String email) {
        return librarianRepository.findByEmailAndIsDeletedFalse(email)
                .orElseThrow(()->new ResourceNotFoundException("Librarian not found"));
    }

    @Override
    public LibrarianCreateResponse createLibrarian(LibrarianCreateRequest librarianCreateRequest) {
        librarianRepository.findByEmailAndIsDeletedFalse(librarianCreateRequest.getEmail())
                .ifPresent(librarian -> {
                    throw new ResourceAlreadyExistException("User already exists with this email");
                });
        Librarian librarian = librarianConverter.apply(librarianCreateRequest);

        librarian.setPassword(passwordEncoder.encode(librarian.getPassword()));

        librarianRepository.save(librarian);

        return  librarianResponseConverter.apply(librarian);

    }
}
