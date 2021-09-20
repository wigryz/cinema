package com.it.cinemabackend.model.movie;

import static org.junit.jupiter.api.Assertions.*;

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
        String name = "Thriller";
        genre.setName(name);
        assertEquals(name, genre.getName());
    }

}
