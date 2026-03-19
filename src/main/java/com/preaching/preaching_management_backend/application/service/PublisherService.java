package com.preaching.preaching_management_backend.application.service;

import com.preaching.preaching_management_backend.domain.exception.publisher.PublisherInvalidDataException;
import com.preaching.preaching_management_backend.domain.exception.publisher.PublisherNotFoundException;
import com.preaching.preaching_management_backend.domain.model.Captain;
import com.preaching.preaching_management_backend.domain.model.Publisher;
import com.preaching.preaching_management_backend.domain.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PublisherService {

    private final PublisherRepository publisherRepository;

    public Publisher createPublisher(Publisher publisher) {
        // Validaciones
        if (publisher.getName() == null || publisher.getName().isBlank()){
            throw new PublisherInvalidDataException("El nombre es obligatorio");
        }

        return publisherRepository.save(publisher);
    }

    public Publisher updatePublisher(UUID id, Publisher publisher) {

        Publisher existing = publisherRepository.findById(id)
                .orElseThrow(() -> new PublisherNotFoundException("Publisher no encontrado"));

        // Validaciones
        if (publisher.getName() == null || publisher.getName().isBlank()){
            throw new PublisherInvalidDataException("El nombre es obligatorio");
        }

        Publisher updated = Publisher.builder()
                .id(existing.getId())
                .name(publisher.getName())
                .phone(publisher.getPhone())
                .build();

        return publisherRepository.save(updated);
    }

    public List<Publisher> getAllCaptains() {
        return publisherRepository.findAll();
    }

    public Publisher getPublisherById(UUID id) {
        return publisherRepository.findById(id)
                .orElseThrow(()-> new PublisherNotFoundException("Publisher no encontrado"));
    }

    public void deletePublisher(UUID id) {
        if (!publisherRepository.findById(id).isPresent()) {
            throw new PublisherNotFoundException("Publisher no encontrado");
        }

        publisherRepository.deleteById(id);
    }
}
