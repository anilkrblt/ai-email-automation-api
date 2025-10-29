package com.anilkarabulut.aiemail.repositories;
import com.anilkarabulut.aiemail.entities.AutomationSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface AutomationSettingRepository extends JpaRepository<AutomationSetting, UUID> {

    // Bir e-posta hesabının ayarlarını bulmak için (OneToOne ilişki)
    Optional<AutomationSetting> findByEmailAccountId(UUID emailAccountId);
}