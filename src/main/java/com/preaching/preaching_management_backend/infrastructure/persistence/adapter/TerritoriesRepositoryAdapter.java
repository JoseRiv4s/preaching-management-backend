package com.preaching.preaching_management_backend.infrastructure.persistence.adapter;

import com.preaching.preaching_management_backend.domain.model.Territories;
import com.preaching.preaching_management_backend.domain.repository.TerritoriesRepository;
import com.preaching.preaching_management_backend.infrastructure.persistence.entity.TerritoriesEntity;
import com.preaching.preaching_management_backend.infrastructure.persistence.mapper.TerritoriesMapper;
import com.preaching.preaching_management_backend.infrastructure.persistence.repository.JpaTerritoriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TerritoriesRepositoryAdapter implements TerritoriesRepository {

    private final JpaTerritoriesRepository jpaRepository;
    private final TerritoriesMapper mapper;

    @Override
    public Territories save(Territories territories) {
        TerritoriesEntity entity = mapper.toEntity(territories);
        TerritoriesEntity savedEntity = jpaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Territories> findById(UUID id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Territories> findAll() {
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
