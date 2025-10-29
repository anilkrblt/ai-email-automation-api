package com.anilkarabulut.aiemail.repositories;

import com.anilkarabulut.aiemail.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    // Spring Security'nin kullanıcıyı bulması için kritik
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}