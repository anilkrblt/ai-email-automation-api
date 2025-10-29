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
@Table(name = "email_accounts")
public class EmailAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "email_address", nullable = false, length = 255)
    private String emailAddress;

    @Column(length = 50)
    private String provider; // İyileştirme: Enum (Provider.GOOGLE, Provider.CUSTOM)

    @Column(name = "imap_server", length = 255)
    private String imapServer;

    @Column(name = "imap_port")
    private Integer imapPort;

    @Column(name = "smtp_server", length = 255)
    private String smtpServer;

    @Column(name = "smtp_port")
    private Integer smtpPort;

    @Column(name = "app_password_encrypted", nullable = false, columnDefinition = "TEXT")
    private String appPasswordEncrypted; // Servis katmanında şifrelenmeli

    @Column(name = "is_active", columnDefinition = "boolean default true")
    private boolean isActive;

    @Column(name = "last_sync_at")
    private LocalDateTime lastSyncAt;

    @Column(name = "last_sync_error", columnDefinition = "TEXT")
    private String lastSyncError;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // --- İlişkiler ---

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ToString.Exclude
    @OneToOne(mappedBy = "emailAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private AutomationSetting automationSetting;

    @ToString.Exclude
    @OneToMany(mappedBy = "emailAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmailLog> emailLogs;
}