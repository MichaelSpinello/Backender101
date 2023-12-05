package com.esercizio.aitho.service;

import com.esercizio.aitho.dto.ProfessionDto;
import com.esercizio.aitho.mapper.ProfessionMapper;
import com.esercizio.aitho.model.Profession;
import com.esercizio.aitho.repository.ProfessionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessionServiceImpl implements ProfessionService {

    final ProfessionRepository repository;
    final ProfessionMapper mapper;

    private ProfessionServiceImpl(ProfessionRepository repository, ProfessionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<ProfessionDto> getAll() {
        List<ProfessionDto> professions = new ArrayList<>();
        repository.findAll().forEach(e -> professions.add(mapper.toDto(e)));
        return professions;
    }

    @Override
    public ProfessionDto findById(Long id) {
        return mapper.toDto(repository.getReferenceById(id));
    }

    @Override
    public Profession save(ProfessionDto dto) {
        return repository.save(mapper.toEntity(dto));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Profession edit(Long id, ProfessionDto professionDto) {
        Profession profession = repository.getReferenceById(id);
        profession.setTitle(professionDto.getTitle());
        return repository.save(profession);
    }

    @Override
    public List<ProfessionDto> filterByName(String firstName, String lastName) {
        List<ProfessionDto> professionDtoList = new ArrayList<>();
        repository.filterByName(firstName, lastName).forEach(e -> professionDtoList.add(mapper.toDto(e)));
        return professionDtoList;
    }

}
