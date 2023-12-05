package com.esercizio.aitho.mapper;

import com.esercizio.aitho.dto.PersonDto;
import com.esercizio.aitho.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(target = "professionTitle", source = "entity.profession.title")
    PersonDto toDto(Person entity);

    Person toEntity(PersonDto dto);

}
