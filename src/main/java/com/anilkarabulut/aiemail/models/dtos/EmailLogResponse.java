package com.anilkarabulut.aiemail.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailLogResponse {
    private UUID id;

    private String fromAddress;

    private String subject;

    private LocalDateTime receivedAt;

    private String status;

    // yanıtın önizlemesi
    private String aiReplyText;

    private String errorMessage;
}
