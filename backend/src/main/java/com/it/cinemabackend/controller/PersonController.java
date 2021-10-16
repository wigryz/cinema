package com.it.cinemabackend.controller;

import com.it.cinemabackend.domain.dto.PersonDTO;
import com.it.cinemabackend.domain.dto.PersonNewDTO;
import com.it.cinemabackend.domain.mapper.ModelMapper;
import com.it.cinemabackend.domain.model.Person;
import com.it.cinemabackend.service.PersonService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class PersonController {

    private final PersonService personService;
    private final ModelMapper modelMapper;

    public PersonController(PersonService personService, ModelMapper modelMapper) {
        this.personService = personService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/person/all")
    public ResponseEntity<List<PersonDTO>> getAll() {
        List<PersonDTO> personDTOs =
            personService.findAll().stream()
                .map(modelMapper::personToPersonDTO)
                .toList();
        return new ResponseEntity<>(personDTOs, HttpStatus.OK);
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<PersonDTO> getById(@PathVariable Long id) {
        PersonDTO personDTO = modelMapper
            .personToPersonDTO(personService.findById(id));
        return new ResponseEntity<>(personDTO, HttpStatus.OK);
    }

    @PostMapping("/person")
    public ResponseEntity<Long> addPerson(@RequestBody PersonNewDTO personNewDTO) {
        Person person = personService.save(modelMapper.personNewDTOTOPerson(personNewDTO));
        return new ResponseEntity<>(person.getId(), HttpStatus.OK);
    }
}
