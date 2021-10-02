package com.it.cinemabackend.repository;

import com.it.cinemabackend.model.movie.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
