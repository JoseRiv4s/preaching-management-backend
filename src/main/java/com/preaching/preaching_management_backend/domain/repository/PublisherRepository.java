package com.preaching.preaching_management_backend.domain.repository;

import com.preaching.preaching_management_backend.domain.model.Publisher;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PublisherRepository {
    Publisher save (Publisher publisher);
    Optional<Publisher> findById(UUID id);
    List<Publisher> findAll();
    void deleteById(UUID id);
}
