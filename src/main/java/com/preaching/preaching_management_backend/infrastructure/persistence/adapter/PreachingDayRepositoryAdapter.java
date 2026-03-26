package com.preaching.preaching_management_backend.infrastructure.persistence.adapter;

import com.preaching.preaching_management_backend.domain.model.PreachingDay;
import com.preaching.preaching_management_backend.domain.repository.PreachingDayRepository;
import com.preaching.preaching_management_backend.infrastructure.persistence.entity.PreachingDayEntity;
import com.preaching.preaching_management_backend.infrastructure.persistence.mapper.PreachingDayMapper;
import com.preaching.preaching_management_backend.infrastructure.persistence.repository.JpaPreachingDayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PreachingDayRepositoryAdapter implements PreachingDayRepository {

    private final JpaPreachingDayRepository jpaRepository;
    private final PreachingDayMapper mapper;

    @Override
    public PreachingDay save(PreachingDay preachingDay) {
        PreachingDayEntity entity = mapper.toEntity(preachingDay);
        PreachingDayEntity savedEntity = jpaRepository.save(entity);
        return  mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<PreachingDay> findById(UUID id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<PreachingDay> findAll() {
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
