package com.preaching.preaching_management_backend.interfaces.rest.mapper;

import com.preaching.preaching_management_backend.domain.model.Territories;
import com.preaching.preaching_management_backend.interfaces.rest.dto.territories.request.CreateTerritoriesRequest;
import com.preaching.preaching_management_backend.interfaces.rest.dto.territories.request.UpdateTerritoriesRequest;
import com.preaching.preaching_management_backend.interfaces.rest.dto.territories.response.TerritoriesResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TerritoriesRestMapper {

    public Territories toDomain(CreateTerritoriesRequest request) {
        return Territories.builder()
                .name(request.getName())
                .build();
    }

    public Territories toDomain(UpdateTerritoriesRequest request, UUID id) {
        return Territories.builder()
                .id(id)
                .name(request.getName())
                .build();
    }

    public TerritoriesResponse toResponse(Territories territories) {
        return TerritoriesResponse.builder()
                .id(territories.getId())
                .name(territories.getName())
                .build();
    }
}
