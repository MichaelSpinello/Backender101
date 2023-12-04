package com.esercizio.aitho.mapper;

import com.esercizio.aitho.dto.ProfessionDto;
import com.esercizio.aitho.model.Profession;
import org.springframework.stereotype.Component;

@Component
public class ProfessionMapper implements Mapper<Profession, ProfessionDto> {
    @Override
    public Profession toEntity(ProfessionDto dto) {
        Profession entity = new Profession();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        return entity;
    }

    @Override
    public ProfessionDto toDto(Profession entity) {
        ProfessionDto dto = new ProfessionDto();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        return dto;
    }
}
