package com.preaching.preaching_management_backend.infrastructure.persistence.mapper;

import com.preaching.preaching_management_backend.domain.model.Captain;
import com.preaching.preaching_management_backend.infrastructure.persistence.entity.CaptainEntity;

public class CaptainMapper {

    private CaptainMapper() {}

    public static CaptainEntity toEntity(Captain captain) {
        return CaptainEntity.builder()
                .id(captain.getId())
                .name(captain.getName())
                .phone(captain.getPhone())
                .email(captain.getEmail())
                .build();
    }

    public static Captain toDomain(CaptainEntity entity) {
        return Captain.builder()
                .id(entity.getId())
                .name(entity.getName())
                .phone(entity.getPhone())
                .email(entity.getEmail())
                .build();
    }
}
