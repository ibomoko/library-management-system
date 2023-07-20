package com.me.librarymanagementsystem.controller;

import com.me.librarymanagementsystem.model.request.librarian.LibrarianCreateRequest;
import com.me.librarymanagementsystem.model.response.librarian.LibrarianCreateResponse;
import com.me.librarymanagementsystem.service.LibrarianService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/api/librarians")
public class LibrarianController {

    private final LibrarianService librarianService;

    @PostMapping
    @PreAuthorize(value = "hasAuthority('ADMIN')")
    public ResponseEntity<LibrarianCreateResponse> createUser(@RequestBody LibrarianCreateRequest librarianCreateRequest){
        return ResponseEntity.ok(librarianService.createLibrarian(librarianCreateRequest));
    }


}
