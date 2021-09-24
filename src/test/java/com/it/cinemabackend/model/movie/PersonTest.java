package com.it.cinemabackend.model.movie;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person person;

    @BeforeEach
    void setUp() {
        person = new Person();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void getSetFirstName() {
        String firstName = "firstName";
        person.setFirstName(firstName);
        assertEquals(firstName, person.getFirstName());
    }

    @Test
    void getSetSecondName() {
        String secondName = "secondName";
        person.setSecondName(secondName);
        assertEquals(secondName, person.getSecondName());
    }

    @Test
    void getSetLastName() {
        String lastName = "lastName";
        person.setLastName(lastName);
        assertEquals(lastName, person.getLastName());
    }

    @Test
    void getSetMoviesAsDirector() {
        Movie movie = new Movie();
        person.setMoviesAsDirector(Set.of(movie));
        assertEquals(1, person.getMoviesAsDirector().size());
    }

    @Test
    void getSetMoviesAsActor() {
        Movie movie = new Movie();
        person.setMoviesAsActor(Set.of(movie));
        assertEquals(1, person.getMoviesAsActor().size());
    }
}