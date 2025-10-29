package com.anilkarabulut.aiemail.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AutomationSettingDto {
    private boolean autoReplyEnabled;

    private int checkFrequency;

    private UUID defaultPromptId;
}
