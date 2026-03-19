package com.preaching.preaching_management_backend.interfaces.rest.controller;

import com.preaching.preaching_management_backend.application.service.CaptainService;
import com.preaching.preaching_management_backend.domain.model.Captain;
import com.preaching.preaching_management_backend.interfaces.rest.dto.captain.request.CreateCaptainRequest;
import com.preaching.preaching_management_backend.interfaces.rest.dto.captain.request.UpdateCaptainRequest;
import com.preaching.preaching_management_backend.interfaces.rest.dto.captain.response.CaptainResponse;
import com.preaching.preaching_management_backend.interfaces.rest.mapper.CaptainRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/captains")
@RequiredArgsConstructor
public class CaptainController {

    private final CaptainService captainService;
    private final CaptainRestMapper mapper;

    @PostMapping
    public ResponseEntity<CaptainResponse> createCaptain(
            @Valid @RequestBody CreateCaptainRequest request) {

        Captain captain = mapper.toDomain(request);
        Captain saved = captainService.createCaptain(captain);

        return ResponseEntity
                .status(HttpStatus.CREATED) // 201
                .body(mapper.toResponse(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CaptainResponse> updateCaptain(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateCaptainRequest request) {

        Captain captain = mapper.toDomain(request, id);
        Captain updated = captainService.updateCaptain(id, captain);

        return ResponseEntity.ok(mapper.toResponse(updated)); // 200
    }

    @GetMapping
    public ResponseEntity<List<CaptainResponse>> getAllCaptains() {

        List<CaptainResponse> response = captainService.getAllCaptains()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response); // 200
    }

    @GetMapping("/{id}")
    public ResponseEntity<CaptainResponse> getCaptainById(@PathVariable UUID id) {

        Captain captain = captainService.getCaptainById(id);

        return ResponseEntity.ok(mapper.toResponse(captain));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCaptain(@PathVariable UUID id) {

        captainService.deleteCaptain(id);

        return ResponseEntity.noContent().build(); // 204
    }
}