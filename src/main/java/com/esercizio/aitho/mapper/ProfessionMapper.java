package com.esercizio.aitho.mapper;

import com.esercizio.aitho.dto.ProfessionDto;
import com.esercizio.aitho.model.Profession;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfessionMapper {

    ProfessionDto toDto(Profession entity);

    Profession toEntity(ProfessionDto dto);
}
