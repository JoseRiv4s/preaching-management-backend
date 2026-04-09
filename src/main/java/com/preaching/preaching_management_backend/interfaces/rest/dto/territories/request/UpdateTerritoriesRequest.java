package com.preaching.preaching_management_backend.interfaces.rest.dto.territories.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateTerritoriesRequest {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 150,message = "El nombre debe tener entre 3 y 150 caracteres")
    private String name;
}
