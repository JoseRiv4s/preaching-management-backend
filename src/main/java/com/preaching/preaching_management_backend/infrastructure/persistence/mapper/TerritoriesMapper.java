package com.preaching.preaching_management_backend.infrastructure.persistence.mapper;

import com.preaching.preaching_management_backend.domain.model.Territories;
import com.preaching.preaching_management_backend.infrastructure.persistence.entity.TerritoriesEntity;
import org.springframework.stereotype.Component;

@Component
public class TerritoriesMapper {

    public TerritoriesEntity toEntity(Territories territories) {
        if (territories == null) return null;

        return TerritoriesEntity.builder()
                .id(territories.getId())
                .name(territories.getName())
                .build();
    }

    public Territories toDomain(TerritoriesEntity entity) {
        if (entity == null) return null;

        return Territories.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}
