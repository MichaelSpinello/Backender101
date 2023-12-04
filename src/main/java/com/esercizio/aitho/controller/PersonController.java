package com.esercizio.aitho.controller;

import com.esercizio.aitho.dto.PersonDto;
import com.esercizio.aitho.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonServiceImpl personService;

    @Autowired
    public PersonController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity getAllPersons(){
        List<PersonDto> personDtoList = personService.getAll();
        if(personDtoList != null && !personDtoList.isEmpty()){
            return new ResponseEntity(personDtoList, HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping(value = "/getProfessionByPerson")
    public ResponseEntity<String> getProfessionByPerson(@RequestParam(required = true) String firstName, @RequestParam(required = true) String lastName){
        List<PersonDto> personDtoList = personService.filterByName(firstName, lastName);
        if(personDtoList != null && !personDtoList.isEmpty()){
            return new ResponseEntity<>(personDtoList.get(0).getProfessionTitle(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    /*@PostMapping(value = "/filter")
    public ResponseEntity filterPerson(@RequestBody PersonDto filter){
        List<PersonDto> personDtoList = personService.searchPerson(filter);
        if(personDtoList != null && !personDtoList.isEmpty()){
            return new ResponseEntity(personDtoList, HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        }
    }*/
}
