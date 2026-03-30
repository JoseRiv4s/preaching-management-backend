package com.preaching.preaching_management_backend.interfaces.rest.dto.preachedBlock.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class CreatePreachedBlockRequest {

    @NotNull(message = "El id del día de predicacción es obligatorio")
    private UUID preachingDayId;

    @NotNull(message = "El id del block es obligatorio")
    private UUID blockId;
}
