package com.preaching.preaching_management_backend.interfaces.rest.dto.preachingParticipant.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class CreateParticipantRequest {

    @NotNull(message = "El día de predicación es obligatorio")
    private UUID preachingDayId;

    @NotNull(message = "El publicador es obligatorio")
    private UUID publisherId;
}
