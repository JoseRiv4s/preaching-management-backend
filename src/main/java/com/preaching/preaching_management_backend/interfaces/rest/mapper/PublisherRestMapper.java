package com.preaching.preaching_management_backend.interfaces.rest.mapper;

import com.preaching.preaching_management_backend.domain.model.Publisher;
import com.preaching.preaching_management_backend.interfaces.rest.dto.publisher.request.CreatePublisherRequest;
import com.preaching.preaching_management_backend.interfaces.rest.dto.publisher.request.UpdatePublisherRequest;
import com.preaching.preaching_management_backend.interfaces.rest.dto.publisher.response.PublisherResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PublisherRestMapper {

    public Publisher toDomain(CreatePublisherRequest request) {
        return Publisher.builder()
                .name(request.getName())
                .phone(request.getPhone())
                .build();
    }

    public Publisher toDomain(UpdatePublisherRequest request, UUID id) {
        return Publisher.builder()
                .id(id)
                .name(request.getName())
                .phone(request.getPhone())
                .build();
    }

    public PublisherResponse toResponse(Publisher publisher) {
        return PublisherResponse.builder()
                .id(publisher.getId())
                .name(publisher.getName())
                .phone(publisher.getPhone())
                .build();
    }
}
