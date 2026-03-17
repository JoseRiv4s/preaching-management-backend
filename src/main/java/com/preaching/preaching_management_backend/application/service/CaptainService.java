package com.preaching.preaching_management_backend.application.service;

import com.preaching.preaching_management_backend.domain.exception.CaptainInvalidDataException;
import com.preaching.preaching_management_backend.domain.exception.CaptainNotFoundException;
import com.preaching.preaching_management_backend.domain.model.Captain;
import com.preaching.preaching_management_backend.domain.repository.CaptainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CaptainService {

    private final CaptainRepository captainRepository;

    public Captain createCaptain(Captain captain) {

        // Validaciones
        if (captain.getName() == null || captain.getName().isBlank()) {
            throw new CaptainInvalidDataException("El nombre es obligatorio");
        }

        if (captain.getEmail() == null || captain.getEmail().isBlank()) {
            throw new CaptainInvalidDataException("El email es obligatorio");
        }

        return captainRepository.save(captain);
    }

    public Captain updateCaptain(UUID id, Captain captain) {

        Captain existing = captainRepository.findById(id)
                .orElseThrow(() -> new CaptainNotFoundException("Captain no encontrado"));

        // Validaciones
        if (captain.getName() == null || captain.getName().isBlank()) {
            throw new CaptainInvalidDataException("El nombre es obligatorio");
        }

        if (captain.getEmail() == null || captain.getEmail().isBlank()) {
            throw new CaptainInvalidDataException("El email es obligatorio");
        }

        // Crear nuevo objeto (INMUTABLE)
        Captain updated = Captain.builder()
                .id(existing.getId())
                .name(captain.getName())
                .phone(captain.getPhone())
                .email(captain.getEmail())
                .build();

        return captainRepository.save(updated);
    }

    public List<Captain> getAllCaptains() {
        return captainRepository.findAll();
    }

    public Captain getCaptainById(UUID id) {
        return captainRepository.findById(id)
                .orElseThrow(() -> new CaptainNotFoundException("Captain no encontrado"));
    }

    public void deleteCaptain(UUID id) {
        if (!captainRepository.findById(id).isPresent()) {
            throw new CaptainNotFoundException("Captain no encontrado");
        }

        captainRepository.deleteById(id);
    }
}