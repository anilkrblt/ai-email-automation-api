package com.anilkarabulut.aiemail.repositories;

import com.anilkarabulut.aiemail.entities.PromptTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PromptTemplateRepository extends JpaRepository<PromptTemplate, UUID> {

    // Bir kullanıcının tüm prompt şablonlarını listelemek için
    List<PromptTemplate> findByUserId(UUID userId);
}