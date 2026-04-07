package com.preaching.preaching_management_backend.interfaces.rest.dto.territories.response;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class TerritoriesResponse {
    private UUID id;
    private String name;
}
