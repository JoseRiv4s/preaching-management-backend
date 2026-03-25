package com.preaching.preaching_management_backend.domain.repository;

import com.preaching.preaching_management_backend.domain.model.PreachingDay;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PreachingDayRepository {
    PreachingDay save (PreachingDay preachingDay);
    Optional<PreachingDay> findById(UUID id);
    List<PreachingDay> findAll();
    void deleteById(UUID id);
}
