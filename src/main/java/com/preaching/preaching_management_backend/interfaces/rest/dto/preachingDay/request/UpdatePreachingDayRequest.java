package com.preaching.preaching_management_backend.interfaces.rest.dto.preachingDay.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class UpdatePreachingDayRequest {

    @NotNull(message = "La fecha es obligatoria")
    private LocalDate date;

    @NotNull(message = "El captain id es obligatorio")
    private UUID captainId;

    @Size(max = 500, message = "Las notas no pueden superar los 500 caracteres")
    private String notes;
}
