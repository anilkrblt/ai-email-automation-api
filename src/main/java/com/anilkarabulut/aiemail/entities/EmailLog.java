package com.anilkarabulut.aiemail.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "email_logs")
public class EmailLog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "incoming_message_id", nullable = false, length = 255)
    private String incomingMessageId;

    @Column(name = "from_address", length = 255)
    private String fromAddress;

    @Column(columnDefinition = "TEXT")
    private String subject;

    @Column(name = "received_at", nullable = false)
    private LocalDateTime receivedAt;

    @Column(nullable = false, length = 50)
    private String status; // Enum: LogStatus.PROCESSING, LogStatus.REPLIED

    @Column(name = "ai_reply_text", columnDefinition = "TEXT")
    private String aiReplyText;

    @Column(name = "error_message", columnDefinition = "TEXT")
    private String errorMessage;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // --- İlişkiler ---

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email_account_id", nullable = false)
    private EmailAccount emailAccount;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rule_applied_id") // Opsiyonel
    private AutomationRule ruleApplied;

    @ToString.Exclude
    @OneToOne(mappedBy = "emailLog", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private AiRequestLog aiRequestLog;
}