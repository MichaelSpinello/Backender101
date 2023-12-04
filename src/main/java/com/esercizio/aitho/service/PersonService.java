package com.esercizio.aitho.service;

import com.esercizio.aitho.dto.PersonDto;
import com.esercizio.aitho.model.Person;

import java.util.List;

public interface PersonService {

    void savePerson(PersonDto dto);
    List<PersonDto> getAll();
    PersonDto findPersonById(Long id);
    void deletePerson(Long id);
    List<PersonDto> filterByName(String firstName, String lastName);
}
