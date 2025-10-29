package com.anilkarabulut.aiemail.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AiUsageResponse {
    private int totalRequestsInPeriod;

    private int maxRequestsInPlan;

    private List<AiRequestLogResponse> logs;
}
