package com.it.cinemabackend.model.movie;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GenreTest {

    Genre genre;

    @BeforeEach
    void setUp() {
        genre = new Genre();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void getSetName() {
        String name = "Horror";
        genre.setName(name);
        assertEquals(name, genre.getName());
    }

    @Test
    void getSetMovies() {
        Movie movie1 = new Movie();
        Movie movie2 = new Movie();
        genre.setMovies(List.of(movie1, movie2));

        assertEquals(2, genre.getMovies().size());
    }
}
