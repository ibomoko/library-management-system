package com.me.librarymanagementsystem.repository;

import com.me.librarymanagementsystem.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
   Optional<Admin> findByEmailAndIsDeletedFalse(String email);

}
