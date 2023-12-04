package com.esercizio.aitho.service;

import com.esercizio.aitho.dto.ProfessionDto;
import com.esercizio.aitho.model.Profession;

import java.util.List;

public interface ProfessionService {

    List<ProfessionDto> getAll();
    ProfessionDto findProfessionById(Long id);
}
