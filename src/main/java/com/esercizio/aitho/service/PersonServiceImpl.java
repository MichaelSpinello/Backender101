package com.esercizio.aitho.service;

import com.esercizio.aitho.dto.PersonDto;
import com.esercizio.aitho.mapper.PersonMapper;
import com.esercizio.aitho.model.Person;
import com.esercizio.aitho.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

    final PersonRepository personRepository;
    final PersonMapper personMapper;

    @Autowired
    private PersonServiceImpl(PersonRepository personRepository, PersonMapper personMapper){
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    @Override
    public void savePerson(PersonDto dto) {
        personRepository.save(personMapper.toEntity(dto));
    }

    @Override
    public List<PersonDto> getAll() {
        List<PersonDto> personDtoList = new ArrayList<>();
        personRepository.findAll().forEach(e -> personDtoList.add(personMapper.toDto(e)));
        return personDtoList;
    }

    @Override
    public PersonDto findPersonById(Long id) {
        return personMapper.toDto(personRepository.getReferenceById(id));
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public List<PersonDto> filterByName(String firstName, String lastName) {
        List<PersonDto> personDtoList = new ArrayList<>();
        personRepository.filterByName(firstName, lastName).forEach(e -> personDtoList.add(personMapper.toDto(e)));
        return personDtoList;
    }
}
