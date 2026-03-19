package com.preaching.preaching_management_backend.interfaces.rest.controller;

import com.preaching.preaching_management_backend.application.service.PublisherService;
import com.preaching.preaching_management_backend.domain.model.Publisher;
import com.preaching.preaching_management_backend.interfaces.rest.dto.publisher.request.CreatePublisherRequest;
import com.preaching.preaching_management_backend.interfaces.rest.dto.publisher.request.UpdatePublisherRequest;
import com.preaching.preaching_management_backend.interfaces.rest.dto.publisher.response.PublisherResponse;
import com.preaching.preaching_management_backend.interfaces.rest.mapper.PublisherRestMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/publishers")
@RequiredArgsConstructor
public class PublisherController {

    private final PublisherService publisherService;
    private final PublisherRestMapper mapper;

    @PostMapping
    public ResponseEntity<PublisherResponse> createPublisher(@Valid @RequestBody CreatePublisherRequest request) {
        Publisher publisher = mapper.toDomain(request);
        Publisher saved = publisherService.createPublisher(publisher);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mapper.toResponse(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublisherResponse> updatePublisher(@PathVariable UUID id, @Valid @RequestBody UpdatePublisherRequest request) {
        Publisher publisher = mapper.toDomain(request, id);
        Publisher updated = publisherService.updatePublisher(id, publisher);

        return ResponseEntity.ok(mapper.toResponse(updated));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublisherResponse> getPublisherById(@PathVariable UUID id) {

        Publisher publisher = publisherService.getPublisherById(id);

        return ResponseEntity.ok(mapper.toResponse(publisher));
    }

    @GetMapping
    public ResponseEntity<List<PublisherResponse>> getAllPublishers() {

        List<PublisherResponse> response = publisherService.getAllPublishers()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublisher(@PathVariable UUID id) {
        publisherService.deletePublisher(id);

        return ResponseEntity.noContent().build();
    }
}
