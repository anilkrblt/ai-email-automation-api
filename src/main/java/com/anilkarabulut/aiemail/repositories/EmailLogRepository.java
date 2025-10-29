package com.anilkarabulut.aiemail.repositories;


import com.anilkarabulut.aiemail.entities.EmailLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmailLogRepository extends JpaRepository<EmailLog, UUID> {

    List<EmailLog> findByEmailAccountId(UUID emailAccountId);

    // Bir e-postanın daha önce işlenip işlenmediğini kontrol etmek için
    boolean existsByEmailAccountIdAndIncomingMessageId(UUID emailAccountId, String incomingMessageId);
}