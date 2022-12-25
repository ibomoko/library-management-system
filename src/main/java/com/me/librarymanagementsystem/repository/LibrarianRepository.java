package com.me.librarymanagementsystem.repository;

import com.me.librarymanagementsystem.entity.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian,Long> {
    Optional<Librarian> findByEmailAndIsDeletedFalse(String email);

}
