package com.preaching.preaching_management_backend.interfaces.rest.controller;

import com.preaching.preaching_management_backend.application.service.BlockService;
import com.preaching.preaching_management_backend.domain.model.Block;
import com.preaching.preaching_management_backend.interfaces.rest.dto.block.request.CreateBlockRequest;
import com.preaching.preaching_management_backend.interfaces.rest.dto.block.request.UpdateBlockRequest;
import com.preaching.preaching_management_backend.interfaces.rest.dto.block.response.BlockResponse;
import com.preaching.preaching_management_backend.interfaces.rest.mapper.BlockRestMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/blocks")
@RequiredArgsConstructor
public class BlockController {

    private final BlockService blockService;
    private final BlockRestMapper mapper;

    @PostMapping
    public ResponseEntity<BlockResponse> createBlock(@Valid @RequestBody CreateBlockRequest request) {

        Block block = mapper.toDomain(request);
        Block saved = blockService.createBlock(block);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mapper.toResponse(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlockResponse> updateBlock(@PathVariable UUID id, @Valid @RequestBody UpdateBlockRequest request) {

        Block block = mapper.toDomain(request, id);
        Block updated = blockService.updateBlock(id, block);

        return ResponseEntity.ok(mapper.toResponse(updated));
    }

    @GetMapping
    public ResponseEntity<List<BlockResponse>> getAllBlocks(){

        List<BlockResponse> response = blockService.getAllBlocks()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlockResponse> getBlockById(@PathVariable UUID id) {

        Block block = blockService.getBlockById(id);

        return ResponseEntity.ok(mapper.toResponse(block));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlock(@PathVariable UUID id) {

        blockService.deleteBlock(id);

        return ResponseEntity.noContent().build();
    }
}
