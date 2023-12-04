package com.esercizio.aitho.service;

import com.esercizio.aitho.dto.ProfessionDto;
import com.esercizio.aitho.mapper.ProfessionMapper;
import com.esercizio.aitho.model.Profession;
import com.esercizio.aitho.repository.ProfessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessionServiceImpl implements ProfessionService{

    final ProfessionRepository personRepository;
    final ProfessionMapper personMapper;

    @Autowired
    private ProfessionServiceImpl(ProfessionRepository personRepository, ProfessionMapper personMapper){
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    @Override
    public List<ProfessionDto> getAll() {
        List<ProfessionDto> professions = new ArrayList<>();
        personRepository.findAll().forEach(e -> professions.add(personMapper.toDto(e)));
        return professions;
    }

    @Override
    public ProfessionDto findProfessionById(Long id) {
        return personMapper.toDto(personRepository.getReferenceById(id));
    }

}
