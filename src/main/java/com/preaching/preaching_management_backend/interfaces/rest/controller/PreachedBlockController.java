package com.preaching.preaching_management_backend.interfaces.rest.controller;

import com.preaching.preaching_management_backend.application.service.PreachedBlockService;
import com.preaching.preaching_management_backend.domain.model.PreachedBlock;
import com.preaching.preaching_management_backend.interfaces.rest.dto.preachedBlock.request.CreatePreachedBlockRequest;
import com.preaching.preaching_management_backend.interfaces.rest.dto.preachedBlock.request.UpdatePreachedBlockRequest;
import com.preaching.preaching_management_backend.interfaces.rest.dto.preachedBlock.response.PreachedBlockResponse;
import com.preaching.preaching_management_backend.interfaces.rest.mapper.PreachedBlockRestMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/preachedBlocks")
@RequiredArgsConstructor
public class PreachedBlockController {

    private final PreachedBlockService preachedBlockService;
    private final PreachedBlockRestMapper mapper;

    @PostMapping
    public ResponseEntity<PreachedBlockResponse> createPreachedBlock(@Valid @RequestBody CreatePreachedBlockRequest request) {

        PreachedBlock preachedBlock = mapper.toDomain(request);
        PreachedBlock saved = preachedBlockService.createPreachedBlock(preachedBlock);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mapper.toResponse(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PreachedBlockResponse> updatePreachedBlock (@PathVariable UUID id, @Valid @RequestBody UpdatePreachedBlockRequest request) {

        PreachedBlock preachedBlock = mapper.toDomain(request, id);
        PreachedBlock updated = preachedBlockService.updatePreachedBlock(id, preachedBlock);

        return ResponseEntity.ok(mapper.toResponse(updated));
    }

    @GetMapping
    public ResponseEntity<List<PreachedBlockResponse>> getAllPreachedBlock(){

        List<PreachedBlockResponse> responses = preachedBlockService.getAllPreachedBlock()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PreachedBlockResponse> getPreachedBlockById(@PathVariable UUID id) {

        PreachedBlock preachedBlock = preachedBlockService.getPreachedBlockById(id);
        return ResponseEntity.ok(mapper.toResponse(preachedBlock));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePreachedBlock(@PathVariable UUID id) {
        preachedBlockService.deletePreachedBlock(id);
        return ResponseEntity.noContent().build();
    }
}
