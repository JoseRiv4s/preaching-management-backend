package com.preaching.preaching_management_backend.interfaces.rest.dto.block.request;

import com.preaching.preaching_management_backend.domain.model.BlockStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.UUID;

@Data
public class UpdateBlockRequest {

    @NotBlank(message = "El número del bloque es obligatorio")
    private String blockNumber;

    private BlockStatus status;
    private String notes;
    private UUID territoryId;
}