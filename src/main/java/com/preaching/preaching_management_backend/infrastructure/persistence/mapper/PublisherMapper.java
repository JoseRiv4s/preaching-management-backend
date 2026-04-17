package com.preaching.preaching_management_backend.infrastructure.persistence.mapper;

import com.preaching.preaching_management_backend.domain.model.Publisher;
import com.preaching.preaching_management_backend.infrastructure.persistence.entity.PublisherEntity;
import org.springframework.stereotype.Component;

@Component
public class PublisherMapper {

    public PublisherEntity toEntity(Publisher publisher) {
        return PublisherEntity.builder()
                .id(publisher.getId())
                .name(publisher.getName())
                .phone(publisher.getPhone())
                .build();
    }

    public Publisher toDomain (PublisherEntity entity) {
        return Publisher.builder()
                .id(entity.getId())
                .name(entity.getName())
                .phone(entity.getPhone())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}
