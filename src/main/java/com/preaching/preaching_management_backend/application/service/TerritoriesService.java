package com.preaching.preaching_management_backend.application.service;

import com.preaching.preaching_management_backend.domain.exception.territories.TerritoriesInvalidDataException;
import com.preaching.preaching_management_backend.domain.exception.territories.TerritoriesNotFoundException;
import com.preaching.preaching_management_backend.domain.model.Territories;
import com.preaching.preaching_management_backend.domain.repository.BlockRepository;
import com.preaching.preaching_management_backend.domain.repository.TerritoriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TerritoriesService {

    private final TerritoriesRepository territoriesRepository;
    private final BlockRepository blockRepository;

    public Territories createTerritories(Territories territories) {

        if (territories.getName() == null || territories.getName().isBlank()) {
            throw new TerritoriesInvalidDataException("El numero es obligatorio");
        }

        return territoriesRepository.save(territories);
    }

    public Territories updateTerritories(UUID id, Territories territories) {

        Territories existing = territoriesRepository.findById(id)
                .orElseThrow(()-> new TerritoriesNotFoundException("Territorio no encontrado"));

        if (territories.getName() == null || territories.getName().isBlank()) {
            throw new TerritoriesInvalidDataException("El numero es obligatorio");
        }

        Territories updated = Territories.builder()
                .id(existing.getId())
                .name(territories.getName())
                .build();

        return territoriesRepository.save(updated);
    }

    public Territories getTerritoriesById(UUID id) {
        return territoriesRepository.findById(id)
                .orElseThrow(()-> new TerritoriesNotFoundException("Territories no encontrado"));
    }

    public List<Territories> getAllTerritories() {
        return territoriesRepository.findAll();
    }

    public void deleteTerritories(UUID id) {
        if (!territoriesRepository.findById(id).isPresent()) {
            throw new TerritoriesNotFoundException("Territorio no encontrado");
        }

        territoriesRepository.deleteById(id);
    }
}
