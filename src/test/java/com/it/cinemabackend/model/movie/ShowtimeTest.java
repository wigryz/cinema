package com.it.cinemabackend.model.movie;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

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
    void getMovie() {
        Movie movie = new Movie();
        showtime.setMovie(movie);
        assertEquals(movie, showtime.getMovie());
    }

    @Test
    void getTechnology() {
        Movie movie = new Movie();
        showtime.setMovie(movie);
        assertEquals(movie, showtime.getMovie());
    }

    @Test
    void getLanguage() {
        showtime.setLanguage(Language.DUBBING);
        assertEquals(Language.DUBBING, showtime.getLanguage());
    }

    @Test
    void getDateTime() {
        LocalDateTime dateTime = LocalDateTime.of(2000, 4, 27, 16, 30);
        showtime.setDateTime(dateTime);
        assertEquals(dateTime, showtime.getDateTime());
    }
}