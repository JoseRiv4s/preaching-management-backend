package com.preaching.preaching_management_backend.interfaces.rest.dto.block.request;

import com.preaching.preaching_management_backend.domain.model.BlockStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.UUID;

@Data
public class CreateBlockRequest {

    @NotBlank(message = "El número del bloque es obligatorio")
    private String blockNumber;
    private String notes;
    private UUID territoryId;
}
