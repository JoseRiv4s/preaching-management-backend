package com.preaching.preaching_management_backend.interfaces.rest.mapper;

import com.preaching.preaching_management_backend.domain.model.PreachingDay;
import com.preaching.preaching_management_backend.interfaces.rest.dto.preachingDay.request.CreatePreachingDayRequest;
import com.preaching.preaching_management_backend.interfaces.rest.dto.preachingDay.request.UpdatePreachingDayRequest;
import com.preaching.preaching_management_backend.interfaces.rest.dto.preachingDay.response.PreachingDayResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PreachingDayRestMapper {

    public PreachingDay toDomain(CreatePreachingDayRequest request) {
        return PreachingDay.builder()
                .date(request.getDate())
                .captainId(request.getCaptainId())
                .notes(request.getNotes())
                .build();
    }

    public PreachingDay toDomain(UpdatePreachingDayRequest request, UUID id) {
        return PreachingDay.builder()
                .id(id)
                .date(request.getDate())
                .captainId(request.getCaptainId())
                .notes(request.getNotes())
                .build();
    }

   public PreachingDayResponse toResponse(PreachingDay preachingDay) {
        return PreachingDayResponse.builder()
                .id(preachingDay.getId())
                .date(preachingDay.getDate())
                .captainId(preachingDay.getCaptainId())
                .notes(preachingDay.getNotes())
                .build();
   }
}
