package com.anilkarabulut.aiemail.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromptTemplateRequest {

    private String templateName;

    private String promptText;

    private String replyTone;

    private boolean isDefault;
}
