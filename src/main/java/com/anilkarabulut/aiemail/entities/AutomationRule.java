package com.anilkarabulut.aiemail.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "automation_rules")
public class AutomationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private int priority;

    @Column(name = "condition_field", nullable = false, length = 50)
    private String conditionField; // Enum: RuleField.FROM, RuleField.SUBJECT

    @Column(name = "condition_operator", nullable = false, length = 50)
    private String conditionOperator; // Enum: RuleOperator.CONTAINS, RuleOperator.EQUALS

    @Column(name = "condition_value", nullable = false, length = 255)
    private String conditionValue;

    @Column(name = "action_type", nullable = false, length = 50)
    private String actionType; // Enum: RuleAction.REPLY, RuleAction.SKIP

    @Column(name = "is_active", columnDefinition = "boolean default true")
    private boolean isActive;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // --- İlişkiler ---

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "automation_setting_id", nullable = false)
    private AutomationSetting automationSetting;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prompt_template_id") // Opsiyonel (nullable = true)
    private PromptTemplate promptTemplate;

    @ToString.Exclude
    @OneToMany(mappedBy = "ruleApplied")
    private List<EmailLog> emailLogs;
}