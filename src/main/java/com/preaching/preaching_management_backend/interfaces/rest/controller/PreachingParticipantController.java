package com.preaching.preaching_management_backend.interfaces.rest.controller;

import com.preaching.preaching_management_backend.application.service.PreachingParticipantService;
import com.preaching.preaching_management_backend.domain.model.PreachingParticipant;
import com.preaching.preaching_management_backend.interfaces.rest.dto.preachingParticipant.request.CreateParticipantRequest;
import com.preaching.preaching_management_backend.interfaces.rest.dto.preachingParticipant.request.UpdateParticipantRequest;
import com.preaching.preaching_management_backend.interfaces.rest.dto.preachingParticipant.response.PreachingParticipantResponse;
import com.preaching.preaching_management_backend.interfaces.rest.mapper.ParticipantRestMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/preachingParticipants")
@RequiredArgsConstructor
public class PreachingParticipantController {

    private final PreachingParticipantService participantService;
    private final ParticipantRestMapper mapper;

    @PostMapping
    public ResponseEntity<PreachingParticipantResponse> createPreachingParticipant(@Valid @RequestBody CreateParticipantRequest request) {

        PreachingParticipant participant = mapper.toDomain(request);
        PreachingParticipant saved = participantService.createPreachingParticipant(participant);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mapper.toResponse(saved));

    }

    @PutMapping("/{id}")
    public ResponseEntity<PreachingParticipantResponse> updatePreachingParticipant(@PathVariable UUID id, @Valid @RequestBody UpdateParticipantRequest request) {

        PreachingParticipant participant = mapper.toDomain(request, id);
        PreachingParticipant updated = participantService.updatePreachingParticipant(id, participant);

        return ResponseEntity.ok(mapper.toResponse(updated));
    }

    @GetMapping
    public ResponseEntity<List<PreachingParticipantResponse>> getAllPreachingParticipant() {

        List<PreachingParticipantResponse> response = participantService.getAllPreachingParticipants()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PreachingParticipantResponse> getPreachingParticipantById(@PathVariable UUID id) {

        PreachingParticipant participant = participantService.getPreachingParticipantById(id);
        return ResponseEntity.ok(mapper.toResponse(participant));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePreachingParticipant(@PathVariable UUID id) {

        participantService.deletePreachingParticipant(id);
        return ResponseEntity.noContent().build();
    }
}
