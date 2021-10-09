package com.it.cinemabackend.services;

import com.it.cinemabackend.model.domain.Person;
import com.it.cinemabackend.repository.PersonRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person findById(Long id) {
        return personRepository.findById(id).orElseThrow();
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }
}
