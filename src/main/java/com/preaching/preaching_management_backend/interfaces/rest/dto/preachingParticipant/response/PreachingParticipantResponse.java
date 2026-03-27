package com.preaching.preaching_management_backend.interfaces.rest.dto.preachingParticipant.response;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class PreachingParticipantResponse {

    private UUID id;
    private UUID preachingDayId;
    private UUID publisherId;
}
