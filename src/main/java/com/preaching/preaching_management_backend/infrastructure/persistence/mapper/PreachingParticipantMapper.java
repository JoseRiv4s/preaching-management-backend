package com.preaching.preaching_management_backend.infrastructure.persistence.mapper;

import com.preaching.preaching_management_backend.domain.model.PreachingParticipant;
import com.preaching.preaching_management_backend.infrastructure.persistence.entity.PreachingDayEntity;
import com.preaching.preaching_management_backend.infrastructure.persistence.entity.PreachingParticipantEntity;
import com.preaching.preaching_management_backend.infrastructure.persistence.entity.PublisherEntity;
import org.springframework.stereotype.Component;

@Component
public class PreachingParticipantMapper {

    public PreachingParticipantEntity toEntity(PreachingParticipant participant) {
        PreachingDayEntity preachingDayEntity = new PreachingDayEntity();
        preachingDayEntity.setId(participant.getPreachingDayId());

        PublisherEntity publisherEntity = new PublisherEntity();
        publisherEntity.setId(participant.getPublisherId());

        return PreachingParticipantEntity.builder()
                .id(participant.getId())
                .preachingDay(preachingDayEntity)
                .publisher(publisherEntity)
                .build();
    }

    public PreachingParticipant toDomain(PreachingParticipantEntity entity) {
        return PreachingParticipant.builder()
                .id(entity.getId())
                .preachingDayId(entity.getPreachingDay().getId())
                .publisherId(entity.getPublisher().getId())
                .build();
    }
}
