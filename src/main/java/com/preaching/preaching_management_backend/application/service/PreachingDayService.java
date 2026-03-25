package com.preaching.preaching_management_backend.application.service;

import com.preaching.preaching_management_backend.domain.exception.captain.CaptainInvalidDataException;
import com.preaching.preaching_management_backend.domain.exception.preachingDay.PreachingDayInvalidDataException;
import com.preaching.preaching_management_backend.domain.exception.preachingDay.PreachingDayNotFoundException;
import com.preaching.preaching_management_backend.domain.exception.publisher.PublisherInvalidDataException;
import com.preaching.preaching_management_backend.domain.model.PreachingDay;
import com.preaching.preaching_management_backend.domain.repository.PreachingDayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PreachingDayService {

    private final PreachingDayRepository preachingDayRepository;

    public PreachingDay createPreachingDay(PreachingDay preachingDay) {

        if (preachingDay.getDate() == null) {
            throw new PreachingDayInvalidDataException("La fecha es obligatoria");
        }

        if (preachingDay.getCaptainId() == null) {
            throw new PreachingDayInvalidDataException("El captain id es obligatorio");
        }

        return preachingDayRepository.save(preachingDay);
    }

    public PreachingDay updatePreachingDay(UUID id, PreachingDay preachingDay) {

        PreachingDay existing = preachingDayRepository.findById(id)
                .orElseThrow(() -> new PreachingDayNotFoundException("PreachingDay no encontrado"));

        if (preachingDay.getDate() == null) {
            throw new PreachingDayInvalidDataException("La fecha es obligatoria");
        }

        if (preachingDay.getCaptainId() == null) {
            throw new PreachingDayInvalidDataException("El captain id es obligatorio");
        }

        PreachingDay updated = PreachingDay.builder()
                .id(existing.getId())
                .date(preachingDay.getDate())
                .captainId(preachingDay.getCaptainId())
                .notes(preachingDay.getNotes())
                .build();

        return preachingDayRepository.save(updated);
    }

    public List<PreachingDay> getAllPreachingDay() {
        return preachingDayRepository.findAll();
    }

    public PreachingDay getPreachingDayById(UUID id) {
        return preachingDayRepository.findById(id)
                .orElseThrow(()-> new PreachingDayNotFoundException("PreachingDay no encontrado"));
    }

    public void deletePreachingDay(UUID id) {
        preachingDayRepository.findById(id)
                .orElseThrow(() -> new PreachingDayNotFoundException("PreachingDay no encontrado"));

        preachingDayRepository.deleteById(id);
    }
}
