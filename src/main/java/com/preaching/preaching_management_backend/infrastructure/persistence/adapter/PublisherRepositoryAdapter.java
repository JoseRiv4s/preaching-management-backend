package com.preaching.preaching_management_backend.infrastructure.persistence.adapter;

import com.preaching.preaching_management_backend.domain.model.Publisher;
import com.preaching.preaching_management_backend.domain.repository.PublisherRepository;
import com.preaching.preaching_management_backend.infrastructure.persistence.entity.PublisherEntity;
import com.preaching.preaching_management_backend.infrastructure.persistence.mapper.PublisherMapper;
import com.preaching.preaching_management_backend.infrastructure.persistence.repository.JpaPublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PublisherRepositoryAdapter implements PublisherRepository {

    private final JpaPublisherRepository jpaRepository;
    private final PublisherMapper mapper;

    @Override
    public Publisher save(Publisher publisher) {
        PublisherEntity entity = mapper.toEntity(publisher);
        PublisherEntity savedEntity = jpaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Publisher> findById(UUID id){
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Publisher> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(UUID id) {
        return jpaRepository.existsById(id);
    }
}
