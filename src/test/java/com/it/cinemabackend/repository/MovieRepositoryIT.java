package com.it.cinemabackend.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.it.cinemabackend.model.movie.Movie;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MovieRepositoryIT {

    @Autowired
    MovieRepository movieRepository;

    @Test
    void initialDataTest() {
        Optional<Movie> foundMovie = movieRepository.findById(0L);
        assertTrue(foundMovie.isPresent());
        assertEquals(0L, foundMovie.get().getId());
    }

    @Test
    void saveAndFindMovie() {
        Movie savedMovie = movieRepository.save(new Movie());
        Optional<Movie> foundMovie = movieRepository.findById(savedMovie.getId());
        assertTrue(foundMovie.isPresent());
        assertEquals(savedMovie.getId(), foundMovie.get().getId());
    }
}
