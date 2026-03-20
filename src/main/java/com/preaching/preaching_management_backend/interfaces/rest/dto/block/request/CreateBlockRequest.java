package com.preaching.preaching_management_backend.interfaces.rest.dto.block.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateBlockRequest {

    @NotBlank(message = "El número del bloque es obligatorio")
    private String blockNumber;

    private String notes;
}
