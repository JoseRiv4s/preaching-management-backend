package com.preaching.preaching_management_backend.interfaces.rest.mapper;

import com.preaching.preaching_management_backend.domain.model.PreachingParticipant;
import com.preaching.preaching_management_backend.interfaces.rest.dto.preachingParticipant.request.CreateParticipantRequest;
import com.preaching.preaching_management_backend.interfaces.rest.dto.preachingParticipant.request.UpdateParticipantRequest;
import com.preaching.preaching_management_backend.interfaces.rest.dto.preachingParticipant.response.PreachingParticipantResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ParticipantRestMapper {

    public PreachingParticipant toDomain(CreateParticipantRequest request) {
        return PreachingParticipant.builder()
                .preachingDayId(request.getPreachingDayId())
                .publisherId(request.getPublisherId())
                .build();
    }

    public PreachingParticipant toDomain(UpdateParticipantRequest request, UUID id) {
        return PreachingParticipant.builder()
                .id(id)
                .preachingDayId(request.getPreachingDayId())
                .publisherId(request.getPublisherId())
                .build();
    }

    public PreachingParticipantResponse toResponse(PreachingParticipant participant) {
        return PreachingParticipantResponse.builder()
                .id(participant.getId())
                .preachingDayId(participant.getPreachingDayId())
                .publisherId(participant.getPublisherId())
                .build();
    }
}
