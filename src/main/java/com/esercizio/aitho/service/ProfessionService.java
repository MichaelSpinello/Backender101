package com.esercizio.aitho.service;

import com.esercizio.aitho.dto.ProfessionDto;
import com.esercizio.aitho.model.Profession;

import java.util.List;

public interface ProfessionService {

    List<ProfessionDto> getAll();

    ProfessionDto findById(Long id);

    Profession save(ProfessionDto dto);

    void delete(Long id);

    Profession edit(Long id, ProfessionDto professionDto);

    List<ProfessionDto> filterByName(String firstName, String lastName);
}
