package com.it.cinemabackend.domain.mapper;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.it.cinemabackend.domain.dto.GenreDTO;
import com.it.cinemabackend.domain.dto.MovieNew;
import com.it.cinemabackend.domain.dto.ShowtimeDTO;
import com.it.cinemabackend.domain.dto.ShowtimeGrouped;
import com.it.cinemabackend.domain.dto.ShowtimeNew;
import com.it.cinemabackend.domain.model.Genre;
import com.it.cinemabackend.domain.model.Language;
import com.it.cinemabackend.domain.model.Movie;
import com.it.cinemabackend.domain.model.Person;
import com.it.cinemabackend.domain.model.Showtime;
import com.it.cinemabackend.domain.model.Technology;
import com.it.cinemabackend.service.MovieService;
import com.it.cinemabackend.service.TechnologyService;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ModelMapperTest {

    @InjectMocks
    // FIND A WAY TO REMOVE THAT WARNING WHEN PROJECT IS NOT COMPILED
    ModelMapper modelMapper = new ModelMapperImpl();

    @Mock
    MovieService movieService;
    @Mock
    TechnologyService technologyService;
    @Mock
    ReferenceMapper referenceMapper;

    Showtime showtime;
    Movie movie;
    Person person;
    Technology technology;
    Genre genre;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        technology = new Technology("tech", null);
        genre = new Genre("genre", null);
        person = Person.builder().firstName("FN").secondName("SN").lastName("LM")
            .portraitPath("path").build();
        movie = Movie.builder().title("T").shortDescription("SD").description("D")
            .yearOfProduction(2000).duration(25).ageRestriction(13).posterPath("path")
            .genres(List.of(genre)).actors(List.of(person)).directors(List.of(person)).build();
        person.setMoviesAsActor(List.of(movie));
        person.setMoviesAsDirector(List.of(movie));
        showtime = Showtime.builder().movie(movie).dateTime(LocalDateTime.now())
            .technology(technology).language(Language.DUBBING).build();
    }

    @Test
    void showtimeToShowtimeDTO() {
        ShowtimeDTO showtimeDTO = modelMapper.showtimeToShowtimeDTO(showtime);
        assertEquals(showtime.getId(), showtimeDTO.getId());
        assertEquals(showtime.getMovie().getId(), showtimeDTO.getMovieId());
        assertEquals(showtime.getMovie().getTitle(), showtimeDTO.getTitle());
        assertEquals(showtime.getMovie().getGenres().stream().map(Genre::getId).toList(),
                     showtimeDTO.getGenres().stream().map(GenreDTO::getId).toList());
        assertEquals(showtime.getMovie().getAgeRestriction(), showtimeDTO.getAgeRestriction());
        assertEquals(showtime.getDateTime(), showtimeDTO.getDateTime());
        assertEquals(showtime.getTechnology().getName(), showtimeDTO.getTechnology());
        assertEquals(showtime.getLanguage().name(), showtimeDTO.getLanguage());
    }

    @Test
    void showtimeToShowtimeGroupedDTO() {
        ShowtimeGrouped showtimeGrouped = modelMapper.showtimeToShowtimeGroupedDTO(showtime);
        assertEquals(showtime.getId(), showtimeGrouped.getShowtimeId());
        assertEquals(showtime.getDateTime(), showtimeGrouped.getDateTime());
        assertEquals(showtime.getTechnology().getName(), showtimeGrouped.getTechnology());
        assertEquals(showtime.getLanguage().name(), showtimeGrouped.getLanguage());
    }

    @Test
    void showtimeNewDTOToShowtime() {
        movie.setId(1L);
        technology.setId(1L);
        when(movieService.findById(1L)).thenReturn(movie);
        when(technologyService.findById(1L)).thenReturn(technology);
        ShowtimeNew showtimeNew = new ShowtimeNew();
        showtimeNew.setMovieId(1L);
        showtimeNew.setDateTime(LocalDateTime.now());
        showtimeNew.setLanguage("DUBBING");
        showtimeNew.setTechnologyId(1L);
        Showtime newShowtime = modelMapper.showtimeNewToShowtime(showtimeNew);

        assertEquals(showtimeNew.getMovieId(), newShowtime.getMovie().getId());
        assertEquals(showtimeNew.getDateTime(), newShowtime.getDateTime());
        assertEquals(showtimeNew.getLanguage(), newShowtime.getLanguage().name());
        assertEquals(showtimeNew.getTechnologyId(), newShowtime.getTechnology().getId());
    }

    @Test
    void movieNewDTOToMovie() {
        person.setId(1L);
        genre.setId(1L);
        MovieNew movieNew = new MovieNew();
        movieNew.setTitle("title");
        movieNew.setShortDescription("shortDesc");
        movieNew.setDescription("desc");
        movieNew.setYearOfProduction(2000);
        movieNew.setDuration(120);
        movieNew.setAgeRestriction(13);
        movieNew.setPosterPath("path");
        movieNew.setImdbId("tt123");
        movieNew.setGenres(List.of(1L));
        movieNew.setDirectors(List.of(1L));
        movieNew.setActors(List.of(1L));

        when(referenceMapper.map(1L, Genre.class)).thenReturn(genre);
        when(referenceMapper.map(1L, Person.class)).thenReturn(person);
        Movie newMovie = modelMapper.movieNewToMovie(movieNew);

        assertEquals(movieNew.getTitle(), newMovie.getTitle());
        assertEquals(movieNew.getGenres().get(0), newMovie.getGenres().get(0).getId());
        assertEquals(movieNew.getActors().get(0), newMovie.getActors().get(0).getId());
        assertEquals(movieNew.getDirectors().get(0), newMovie.getDirectors().get(0).getId());
    }
}
