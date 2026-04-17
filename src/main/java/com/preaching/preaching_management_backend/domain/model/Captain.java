package com.preaching.preaching_management_backend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Captain {
    private UUID id;
    private String name;
    private String phone;
    private String email;
    private OffsetDateTime createdAt;
}


