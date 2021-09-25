package com.it.cinemabackend.model.movie;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MovieTest {

    Movie movie;

    @BeforeEach
    void setUp() {
        movie = new Movie();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void getSetTitle() {
        String title = "title";
        movie.setTitle(title);
        assertEquals(title, movie.getTitle());
    }

    @Test
    void getSetShortDescription() {
        String shortDescription = "short description";
        movie.setShortDescription(shortDescription);
        assertEquals(shortDescription, movie.getShortDescription());
    }

    @Test
    void getSetDescription() {
        String description = "description";
        movie.setDescription(description);
        assertEquals(description, movie.getDescription());
    }

    @Test
    void getSetYearOfProduction() {
        Integer yearOfProduction = 5;
        movie.setYearOfProduction(yearOfProduction);
        assertEquals(yearOfProduction, movie.getYearOfProduction());
    }

    @Test
    void getSetDuration() {
        Integer duration = 5;
        movie.setDuration(duration);
        assertEquals(duration, movie.getDuration());
    }

    @Test
    void getSetAdditionalInfo() {
        String additionalInfo = "additional_info";
        movie.setAdditionalInfo(additionalInfo);
        assertEquals(additionalInfo, movie.getAdditionalInfo());
    }

    @Test
    void getSetAgeRestriction() {
        Integer ageRestriction = 15;
        movie.setAgeRestriction(ageRestriction);
        assertEquals(ageRestriction, movie.getAgeRestriction());
    }

    @Test
    void getSetPosterPath() {
        String posterPath = "~/path/to/poster";
        movie.setPosterPath(posterPath);
        assertEquals(posterPath, movie.getPosterPath());
    }

    @Test
    void getSetImdbId() {
        String imdbId = "tt123456";
        movie.setImdbId(imdbId);
        assertEquals(imdbId, movie.getImdbId());
    }

    @Test
    void getSetShowtimes() {
        Showtime showtime = new Showtime();
        movie.setShowtimes(List.of(showtime));
        assertEquals(1, movie.getShowtimes().size());
    }

    @Test
    void getSetGenres() {
        Genre genre = new Genre();
        movie.setGenres(List.of(genre));
        assertEquals(1, movie.getGenres().size());
    }

    @Test
    void getSetDirectors() {
        Person person = new Person();
        movie.setDirectors(List.of(person));
        assertEquals(1, movie.getDirectors().size());
    }

    @Test
    void getSetActors() {
        Person person = new Person();
        movie.setActors(List.of(person));
        assertEquals(1, movie.getActors().size());
    }
}
