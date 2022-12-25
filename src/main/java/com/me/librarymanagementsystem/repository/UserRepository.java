package com.me.librarymanagementsystem.repository;

import com.me.librarymanagementsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
    Optional<User> getUserById(Long id);
    Optional<User> getUserByEmail(String email);
    void deleteUserById(Long id);
    Optional<User> findByEmailAndIsDeletedFalse(String email);
}
