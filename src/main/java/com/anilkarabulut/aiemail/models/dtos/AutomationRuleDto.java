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
public class AutomationRuleDto {

    private UUID id;

    private int priority;

    private String conditionField;

    private String conditionOperator;

    private String conditionValue;

    private String actionType;

    private UUID promptTemplateId;

    private boolean isActive;
}
