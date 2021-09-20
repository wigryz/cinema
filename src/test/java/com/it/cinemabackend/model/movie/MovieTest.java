package com.it.cinemabackend.model.movie;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        String title = "The Batman";
        movie.setTitle(title);
        assertEquals(title, movie.getTitle());
    }

    @Test
    void getSetDescription() {
        String description = "Some kind of description";
        movie.setDescription(description);
        assertEquals(description, movie.getDescription());
    }

    @Test
    void getSetYearOfProduction() {
        Integer yearOfProduction = 1997;
        movie.setYearOfProduction(yearOfProduction);
        assertEquals(yearOfProduction, movie.getYearOfProduction());
    }

    @Test
    void getSetCountry() {
        Country country = new Country();
        country.setName("Poland");
        movie.setCountry(country);
        assertEquals(country, movie.getCountry());
    }

    @Test
    void getSetDuration() {
        Integer duration = 137;
        movie.setDuration(duration);
        assertEquals(duration, movie.getDuration());
    }

    @Test
    void getSetAdditionalInfo() {
        String additionalInfo = "Additional info";
        movie.setAdditionalInfo(additionalInfo);
        assertEquals(additionalInfo, movie.getAdditionalInfo());
    }

    @Test
    void getSetMoviePeople() {
        MoviePerson person1 = new MoviePerson();
        MoviePerson person2 = new MoviePerson();
        Set<MoviePerson> people = Set.of(person1, person2);
        movie.setMoviePeople(people);
        assertEquals(people, movie.getMoviePeople());
        assertEquals(people.size(), movie.getMoviePeople().size());
    }

    @Test
    void getSetGenres() {
        Genre genre1 = new Genre();
        Genre genre2 = new Genre();
        Set<Genre> genres = Set.of(genre1, genre2);
        movie.setGenres(genres);
        assertEquals(genres, movie.getGenres());
        assertEquals(genres.size(), movie.getGenres().size());
    }

    @Test
    void getSetTechnologies() {
        Technology technology1 = new Technology();
        Technology technology2 = new Technology();
        Set<Technology> technologies = Set.of(technology1, technology2);
        movie.setTechnologies(technologies);
        assertEquals(technologies, movie.getTechnologies());
        assertEquals(technologies.size(), movie.getTechnologies().size());
    }

    @Test
    void getSetRating() {
        Double rating = 0.0;
        movie.setRating(rating);
        assertEquals(rating, movie.getRating());
    }
}
