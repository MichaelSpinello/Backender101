package com.esercizio.aitho.mapper;

import com.esercizio.aitho.dto.PersonDto;
import com.esercizio.aitho.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper implements Mapper<Person, PersonDto> {
    @Override
    public Person toEntity(PersonDto dto) {
        Person entity = new Person();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        //entity.setProfession(dto.getProfessionTitle());
        return entity;
    }

    @Override
    public PersonDto toDto(Person entity) {
        PersonDto dto = new PersonDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setProfessionTitle(entity.getProfession().getTitle());
        return dto;
    }
}
