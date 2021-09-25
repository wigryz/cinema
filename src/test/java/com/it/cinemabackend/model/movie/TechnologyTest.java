package com.it.cinemabackend.model.movie;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TechnologyTest {

    Technology technology;

    @BeforeEach
    void setUp() {
        technology = new Technology();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void getSetName() {
        String name = "3D";
        technology.setName(name);
        assertEquals(name, technology.getName());
    }

    @Test
    void getSetMovies() {
        Showtime showtime1 = new Showtime();
        Showtime showtime2 = new Showtime();
        technology.setShowtimes(List.of(showtime1, showtime2));
        assertEquals(2, technology.getShowtimes().size());
    }

}
