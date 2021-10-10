package com.it.cinemabackend.service;

import static org.junit.jupiter.api.Assertions.*;

import com.it.cinemabackend.model.domain.Movie;
import com.it.cinemabackend.model.domain.Showtime;
import com.it.cinemabackend.model.domain.Technology;
import com.it.cinemabackend.repository.ShowtimeRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;

@DataJpaTest
@ComponentScan(basePackageClasses = { ShowtimeRepository.class, ShowtimeService.class, TechnologyService.class })
class ShowtimeServiceIT {

    @Autowired
    ShowtimeService showtimeService;
    @Autowired
    MovieService movieService;
    @Autowired
    TechnologyService technologyService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    // --- more like unit tests
    @Test
    void failSavingNullObjectTest() {
        assertThrows(InvalidDataAccessApiUsageException.class, () -> showtimeService.save(null));
    }

    @Test
    void failSavingShowtimeWithNullMovieTest() {
        Showtime showtime = new Showtime();
        showtime.setMovie(null);
        assertThrows(DataIntegrityViolationException.class, () -> showtimeService.save(showtime));
    }

    @Test
    void failSavingShowtimeWithNullTechnologyTest() {
        Showtime showtime = new Showtime();
        showtime.setTechnology(null);
        assertThrows(DataIntegrityViolationException.class, () -> showtimeService.save(showtime));
    }

    @Test
    void failSavingShowtimeWithNullDateTest() {
        Showtime showtime = new Showtime();
        showtime.setDateTime(null);
        assertThrows(DataIntegrityViolationException.class, () -> showtimeService.save(showtime));
    }
    // ---

    @Test
    void initialDataTest() {
        List<Showtime> showtimes = showtimeService.findAll();
        assertFalse(showtimes.isEmpty());
    }

    @Test
    void findCurrentShowtimesTest() {
        Movie movie = movieService.findAll().stream().findFirst().orElseThrow();
        Technology technology = technologyService.findAll().stream().findFirst().orElseThrow();
        Showtime showtime = new Showtime();
        showtime.setMovie(movie);
        showtime.setTechnology(technology);
        showtime.setDateTime(LocalDateTime.now());

        showtimeService.save(showtime);
        List<Showtime> currentShowtimes = showtimeService.findCurrent();

        assertTrue(currentShowtimes.contains(showtime));
    }

    @Test
    void findCurrentShowtimesFailTest() {
        Movie movie = movieService.findAll().stream().findFirst().orElseThrow();
        Technology technology = technologyService.findAll().stream().findFirst().orElseThrow();
        Showtime showtime1 = new Showtime();
        showtime1.setMovie(movie);
        showtime1.setTechnology(technology);
        showtime1.setDateTime(LocalDateTime.now().minusDays(1));

        Showtime showtime2 = new Showtime();
        showtime2.setMovie(movie);
        showtime2.setTechnology(technology);
        showtime2.setDateTime(LocalDateTime.now().plusDays(1));

        showtimeService.save(showtime1);
        showtimeService.save(showtime2);
        List<Showtime> currentShowtimes = showtimeService.findCurrent();

        assertTrue(!currentShowtimes.contains(showtime1) && !currentShowtimes.contains(showtime2));
    }
}
