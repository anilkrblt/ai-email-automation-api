package com.anilkarabulut.aiemail.repositories;

import com.anilkarabulut.aiemail.entities.AutomationRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AutomationRuleRepository extends JpaRepository<AutomationRule, UUID> {

    // Bir ayar setine bağlı tüm kuralları öncelik sırasına göre getirir
    List<AutomationRule> findByAutomationSettingIdAndIsActiveTrueOrderByPriorityAsc(UUID automationSettingId);
}