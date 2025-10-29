package com.anilkarabulut.aiemail.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailAccountCreateRequest {
    private String emailAddress;
    private String provider;
    private String imapServer;

    private Integer imapPort;

    private String smtpServer;

    private Integer smtpPort;

    private String appPassword;
}
