package com.esercizio.aitho.controller;

import com.esercizio.aitho.dto.NamesRequestDto;
import com.esercizio.aitho.dto.PersonDto;
import com.esercizio.aitho.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<String> getNamesByFirstLetter(
            @RequestBody @Valid NamesRequestDto namesRequestDto) {
        String names = personService.getNamesByFirstLetter(namesRequestDto.getFirstLetter());
        return new ResponseEntity<>(names, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
