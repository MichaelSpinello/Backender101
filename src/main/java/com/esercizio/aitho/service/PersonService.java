package com.esercizio.aitho.service;

import com.esercizio.aitho.dto.PersonDto;

import java.util.List;

public interface PersonService {

    void savePerson(PersonDto dto);

    List<PersonDto> getAll();

    PersonDto findPersonById(Long id);

    void deletePerson(Long id);

    String getNamesByFirstLetter(String character);
}
