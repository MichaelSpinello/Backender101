package com.esercizio.aitho.service;

import com.esercizio.aitho.dto.PersonDto;
import com.esercizio.aitho.mapper.PersonMapper;
import com.esercizio.aitho.model.Person;
import com.esercizio.aitho.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    final PersonRepository repository;
    final PersonMapper mapper;

    private PersonServiceImpl(PersonRepository repository, PersonMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void savePerson(PersonDto dto) {
        repository.save(mapper.toEntity(dto));
    }

    @Override
    public List<PersonDto> getAll() {
        List<PersonDto> personDtoList = new ArrayList<>();
        repository.findAll().forEach(e -> personDtoList.add(mapper.toDto(e)));
        return personDtoList;
    }

    @Override
    public PersonDto findPersonById(Long id) {
        return mapper.toDto(repository.getReferenceById(id));
    }

    @Override
    public void deletePerson(Long id) {
        repository.deleteById(id);
    }


    @Override
    public String getNamesByFirstLetter(String character) {
        List<Person> personList = repository.getByFirstNameChar(character);
        return personList.stream().map(Person::getFirstName).collect(Collectors.joining(", "));
    }
}
