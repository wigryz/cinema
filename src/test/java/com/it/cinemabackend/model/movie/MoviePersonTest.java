package com.it.cinemabackend.model.movie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MoviePersonTest {

    MoviePerson moviePerson;

    @BeforeEach
    void setUp() {
        moviePerson = new MoviePerson();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getSetPerson() {
        Person person = new Person();
        moviePerson.setPerson(person);
        assertEquals(person, moviePerson.getPerson());
    }

    @Test
    void getSetMovie() {
        Movie movie = new Movie();
        moviePerson.setMovie(movie);
        assertEquals(movie, moviePerson.getMovie());
    }

    @Test
    void getSetParticipationType() {
        moviePerson.setParticipationType(MoviePerson.ParticipationType.ACTOR);
        assertEquals(MoviePerson.ParticipationType.ACTOR, moviePerson.getParticipationType());
    }

}
