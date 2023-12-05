package com.esercizio.aitho.controller;

import com.esercizio.aitho.dto.ProfessionDto;
import com.esercizio.aitho.model.Profession;
import com.esercizio.aitho.service.ProfessionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professions")
public class ProfessionController {

    private final ProfessionService professionService;

    public ProfessionController(ProfessionService professionService) {
        this.professionService = professionService;
    }

    @GetMapping
    public ResponseEntity<List<ProfessionDto>> getAll() {
        List<ProfessionDto> professionDtoList = professionService.getAll();
        if (professionDtoList != null && !professionDtoList.isEmpty()) {
            return new ResponseEntity<>(professionDtoList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping(value = "/persons/search")
    public ResponseEntity<String> getProfessionByPerson(@RequestParam String firstName, @RequestParam String lastName) {
        List<ProfessionDto> personDtoList = professionService.filterByName(firstName, lastName);
        if (personDtoList != null && !personDtoList.isEmpty()) {
            return new ResponseEntity<>(personDtoList.get(0).getTitle(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @PostMapping
    public ResponseEntity<Profession> insert(@Validated @RequestBody ProfessionDto newProfession) {
        Profession profession = professionService.save(newProfession);
        return new ResponseEntity<>(profession, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        professionService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Profession> edit(@PathVariable Long id, @Validated @RequestBody ProfessionDto profession) {
        Profession editedProfession = professionService.edit(id, profession);
        return new ResponseEntity<>(editedProfession, HttpStatus.OK);
    }
}
