package com.preaching.preaching_management_backend.interfaces.rest.controller;

import com.preaching.preaching_management_backend.application.service.TerritoriesService;
import com.preaching.preaching_management_backend.domain.model.Territories;
import com.preaching.preaching_management_backend.interfaces.rest.dto.territories.request.CreateTerritoriesRequest;
import com.preaching.preaching_management_backend.interfaces.rest.dto.territories.request.UpdateTerritoriesRequest;
import com.preaching.preaching_management_backend.interfaces.rest.dto.territories.response.TerritoriesResponse;
import com.preaching.preaching_management_backend.interfaces.rest.mapper.TerritoriesRestMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/territories")
@RequiredArgsConstructor
public class TerritoriesController {

    private final TerritoriesService territoriesService;
    private final TerritoriesRestMapper mapper;

    @PostMapping
    public ResponseEntity<TerritoriesResponse> createTerritories(@Valid @RequestBody CreateTerritoriesRequest request) {

        Territories territories = mapper.toDomain(request);
        Territories saved = territoriesService.createTerritories(territories);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mapper.toResponse(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TerritoriesResponse> updateTerritories(@PathVariable UUID id, @Valid @RequestBody UpdateTerritoriesRequest request) {
        Territories territories = mapper.toDomain(request, id);
        Territories updated = territoriesService.updateTerritories(id, territories);

        return ResponseEntity.ok(mapper.toResponse(updated));
    }

    @GetMapping
    public ResponseEntity<List<TerritoriesResponse>> getAllTerritories() {

        List<TerritoriesResponse> responses = territoriesService.getAllTerritories()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TerritoriesResponse> getTerritoriesById(@PathVariable UUID id) {
        Territories territories = territoriesService.getTerritoriesById(id);

        return ResponseEntity.ok(mapper.toResponse(territories));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTerritories(@PathVariable UUID id) {
        territoriesService.deleteTerritories(id);

        return ResponseEntity.noContent().build();
    }
}
