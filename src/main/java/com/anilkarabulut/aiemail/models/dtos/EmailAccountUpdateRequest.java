package com.anilkarabulut.aiemail.models.dtos;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailAccountUpdateRequest {
    private UUID id;

    private String emailAddress;

    private String provider;

    private boolean isActive;

    private LocalDateTime lastSyncAt;


    private String lastSyncError;


}
