package com.preaching.preaching_management_backend.interfaces.rest.controller;

import com.preaching.preaching_management_backend.application.service.PreachingDayService;
import com.preaching.preaching_management_backend.domain.model.PreachingDay;
import com.preaching.preaching_management_backend.interfaces.rest.dto.preachingDay.request.CreatePreachingDayRequest;
import com.preaching.preaching_management_backend.interfaces.rest.dto.preachingDay.request.UpdatePreachingDayRequest;
import com.preaching.preaching_management_backend.interfaces.rest.dto.preachingDay.response.PreachingDayResponse;
import com.preaching.preaching_management_backend.interfaces.rest.mapper.PreachingDayRestMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/preachingDays")
@RequiredArgsConstructor
public class PreachingDayController {

    private final PreachingDayService preachingDayService;
    private final PreachingDayRestMapper mapper;

    @PostMapping
    public ResponseEntity<PreachingDayResponse> createPreachingDay(@Valid @RequestBody CreatePreachingDayRequest request) {
        PreachingDay preachingDay = mapper.toDomain(request);
        PreachingDay saved = preachingDayService.createPreachingDay(preachingDay);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mapper.toResponse(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PreachingDayResponse> updatePreachingDay(@PathVariable UUID id, @Valid @RequestBody UpdatePreachingDayRequest request) {

        PreachingDay preachingDay = mapper.toDomain(request, id);
        PreachingDay updated = preachingDayService.updatePreachingDay(id, preachingDay);

        return ResponseEntity.ok(mapper.toResponse(updated));
    }

    @GetMapping
    public ResponseEntity<List<PreachingDayResponse>> getAllPreachingDay() {
        List<PreachingDayResponse> response = preachingDayService.getAllPreachingDay()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PreachingDayResponse> getPreachingDayById(@PathVariable UUID id) {

        PreachingDay preachingDay = preachingDayService.getPreachingDayById(id);
        return ResponseEntity.ok(mapper.toResponse(preachingDay));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePreachingDay (@PathVariable UUID id) {

        preachingDayService.deletePreachingDay(id);
        return ResponseEntity.noContent().build();
    }

}
