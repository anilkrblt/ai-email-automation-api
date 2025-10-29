package com.anilkarabulut.aiemail.repositories;


import com.anilkarabulut.aiemail.entities.EmailAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmailAccountRepository extends JpaRepository<EmailAccount, UUID> {

    // Bir kullanıcının tüm e-posta hesaplarını listelemek için
    List<EmailAccount> findByUserId(UUID userId);

    // Periyodik e-posta kontrolü yapacak olan (Scheduler) servis için
    List<EmailAccount> findAllByIsActiveTrue();
}