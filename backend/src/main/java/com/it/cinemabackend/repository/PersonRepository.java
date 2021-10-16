package com.it.cinemabackend.repository;

import com.it.cinemabackend.domain.model.Person;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findAll();
}
