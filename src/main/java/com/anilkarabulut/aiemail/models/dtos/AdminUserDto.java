package com.anilkarabulut.aiemail.models.dtos;

import com.anilkarabulut.aiemail.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminUserDto {

    private UUID id;
    private String email;
    private String passwordHash;
    private Role role;
    private LocalDateTime createdAt;
}
