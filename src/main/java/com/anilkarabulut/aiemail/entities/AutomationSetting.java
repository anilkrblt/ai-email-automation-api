package com.anilkarabulut.aiemail.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "automation_settings")
public class AutomationSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "auto_reply_enabled", columnDefinition = "boolean default false")
    private boolean autoReplyEnabled;

    @Column(name = "check_frequency", columnDefinition = "integer default 15")
    private Integer checkFrequency;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // --- İlişkiler ---

    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email_account_id", nullable = false, unique = true)
    private EmailAccount emailAccount;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "default_prompt_id", nullable = false)
    private PromptTemplate defaultPrompt;

    @ToString.Exclude
    @OneToMany(mappedBy = "automationSetting", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("priority ASC") // Kuralların sırayla gelmesi için
    private List<AutomationRule> automationRules;
}