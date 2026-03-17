package com.preaching.preaching_management_backend.infrastructure.persistence.adapter;

import com.preaching.preaching_management_backend.domain.model.Captain;
import com.preaching.preaching_management_backend.domain.repository.CaptainRepository;
import com.preaching.preaching_management_backend.infrastructure.persistence.entity.CaptainEntity;
import com.preaching.preaching_management_backend.infrastructure.persistence.mapper.CaptainMapper;
import com.preaching.preaching_management_backend.infrastructure.persistence.repository.JpaCaptainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CaptainRepositoryAdapter implements CaptainRepository {

    private final JpaCaptainRepository jpaRepository;
    private final CaptainMapper mapper;

    @Override
    public Captain save(Captain captain) {
        CaptainEntity entity = mapper.toEntity(captain);
        CaptainEntity savedEntity = jpaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Captain> findById(UUID id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Captain> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        jpaRepository.deleteById(id);
    }
}
