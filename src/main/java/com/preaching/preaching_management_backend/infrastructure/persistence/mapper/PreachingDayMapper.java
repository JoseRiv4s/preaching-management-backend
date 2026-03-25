package com.preaching.preaching_management_backend.infrastructure.persistence.mapper;

import com.preaching.preaching_management_backend.domain.model.PreachingDay;
import com.preaching.preaching_management_backend.infrastructure.persistence.entity.PreachingDayEntity;
import org.springframework.stereotype.Component;

@Component
public class PreachingDayMapper {

    public PreachingDayEntity toEntity(PreachingDay preachingDay) {
        return PreachingDayEntity.builder()
                .id(preachingDay.getId())
                .date(preachingDay.getDate())
                .captainId(preachingDay.getCaptainId())
                .notes(preachingDay.getNotes())
                .build();
    }

    public PreachingDay toDomain(PreachingDayEntity entity) {
        return PreachingDay.builder()
                .id(entity.getId())
                .date(entity.getDate())
                .captainId(entity.getCaptainId())
                .notes(entity.getNotes())
                .build();
    }
}
