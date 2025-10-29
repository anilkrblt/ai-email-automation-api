package com.anilkarabulut.aiemail.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromptTemplateResponse {
    private UUID id;

    private String templateName;

    private String promptText;

    private String replyTone;

    private boolean isDefault;

    private LocalDateTime createdAt;
}
