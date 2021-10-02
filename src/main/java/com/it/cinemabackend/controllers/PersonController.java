package com.it.cinemabackend.controllers;

import com.it.cinemabackend.mappers.PersonMapper;
import com.it.cinemabackend.model.dto.PersonDTO;
import com.it.cinemabackend.services.PersonService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;
    private final PersonMapper personMapper;

    public PersonController(PersonService personService, PersonMapper personMapper) {
        this.personService = personService;
        this.personMapper = personMapper;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PersonDTO>> getAll() {
        List<PersonDTO> personDTOs =
            personService.findAll().stream()
                .map(personMapper::personToPersonDTO)
                .toList();
        return new ResponseEntity<>(personDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> getById(@PathVariable Long id) {
        PersonDTO personDTO = personMapper
            .personToPersonDTO(personService.findById(id));
        return new ResponseEntity<>(personDTO, HttpStatus.OK);
    }
}
