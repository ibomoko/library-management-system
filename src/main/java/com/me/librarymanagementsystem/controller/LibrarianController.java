package com.me.librarymanagementsystem.controller;

import com.me.librarymanagementsystem.model.request.librarian.LibrarianCreateRequest;
import com.me.librarymanagementsystem.model.response.librarian.LibrarianCreateResponse;
import com.me.librarymanagementsystem.service.LibrarianService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/librarian")
public class LibrarianController {

    private final LibrarianService librarianService;

    @PostMapping("/createLibrarian")
    public ResponseEntity<LibrarianCreateResponse> createUser(LibrarianCreateRequest librarianCreateRequest){
        return ResponseEntity.ok(librarianService.createLibrarian(librarianCreateRequest));
    }


}
