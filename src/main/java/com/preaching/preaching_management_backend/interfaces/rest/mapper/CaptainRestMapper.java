package com.preaching.preaching_management_backend.interfaces.rest.mapper;

import com.preaching.preaching_management_backend.domain.model.Captain;
import com.preaching.preaching_management_backend.interfaces.rest.dto.request.CreateCaptainRequest;
import com.preaching.preaching_management_backend.interfaces.rest.dto.request.UpdateCaptainRequest;
import com.preaching.preaching_management_backend.interfaces.rest.dto.response.CaptainResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CaptainRestMapper {

    public Captain toDomain(CreateCaptainRequest request) {
        return Captain.builder()
                .name(request.getName())
                .phone(request.getPhone())
                .email(request.getEmail())
                .build();
    }

    public Captain toDomain(UpdateCaptainRequest request, UUID id) {
        return Captain.builder()
                .id(id)
                .name(request.getName())
                .phone(request.getPhone())
                .email(request.getEmail())
                .build();
    }

    public CaptainResponse toResponse(Captain captain) {
        return CaptainResponse.builder()
                .id(captain.getId())
                .name(captain.getName())
                .phone(captain.getPhone())
                .email(captain.getEmail())
                .build();
    }
}