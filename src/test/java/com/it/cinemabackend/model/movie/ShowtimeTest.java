package com.it.cinemabackend.model.movie;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShowtimeTest {

    Showtime showtime;

    @BeforeEach
    void setUp() {
        showtime = new Showtime();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void getSetMovie() {
        Movie movie = new Movie();
        showtime.setMovie(movie);
        assertEquals(movie, showtime.getMovie());
    }

    @Test
    void getSetTechnology() {
        Technology technology = new Technology();
        showtime.setTechnology(technology);
        assertEquals(technology, showtime.getTechnology());
    }

    @Test
    void getSetLanguage() {
        showtime.setLanguage(Language.DUBBING);
        assertEquals(Language.DUBBING, showtime.getLanguage());
    }

    @Test
    void getSetDateTime() {
        LocalDateTime dateTime = LocalDateTime.of(2000, 4, 27, 16, 30);
        showtime.setDateTime(dateTime);
        assertEquals(dateTime, showtime.getDateTime());
    }
}
