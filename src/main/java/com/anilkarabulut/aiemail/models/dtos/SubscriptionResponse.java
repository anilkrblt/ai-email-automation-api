package com.anilkarabulut.aiemail.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubscriptionResponse {

    private String planId;

    private SubscriptionStatus status;

    private LocalDateTime trialEndsAt;

    private LocalDateTime currentPeriodEndsAt;

}
