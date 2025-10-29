package com.anilkarabulut.aiemail.repositories;


import com.anilkarabulut.aiemail.entities.AiRequestLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AiRequestLogRepository extends JpaRepository<AiRequestLog, UUID> {

    // Bir kullanıcının tüm AI kullanım loglarını görmek için
    List<AiRequestLog> findByUserId(UUID userId);
}