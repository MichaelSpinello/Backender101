package com.esercizio.aitho.controller;

import com.esercizio.aitho.dto.NamesRequestDto;
import com.esercizio.aitho.dto.PersonDto;
import com.esercizio.aitho.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/persons")
@Validated
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> getAll() {
        List<PersonDto> personDtoList = personService.getAll();
        if (personDtoList != null && !personDtoList.isEmpty()) {
            return new ResponseEntity<>(personDtoList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping(value = "/names")
    public ResponseEntity<String> getNamesByFirstLetter(@RequestBody @Valid NamesRequestDto namesRequestDto) {
        String names = personService.getNamesByFirstLetter(namesRequestDto.getFirstLetter());
        if(names.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(names, HttpStatus.OK);
    }

}
