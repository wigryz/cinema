package com.it.cinemabackend.mapper;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.it.cinemabackend.model.domain.Genre;
import com.it.cinemabackend.model.domain.Language;
import com.it.cinemabackend.model.domain.Movie;
import com.it.cinemabackend.model.domain.Person;
import com.it.cinemabackend.model.domain.Showtime;
import com.it.cinemabackend.model.domain.Technology;
import com.it.cinemabackend.model.dto.GenreDTO;
import com.it.cinemabackend.model.dto.MovieNewDTO;
import com.it.cinemabackend.model.dto.ShowtimeDTO;
import com.it.cinemabackend.model.dto.ShowtimeGroupedDTO;
import com.it.cinemabackend.model.dto.ShowtimeNewDTO;
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
            .genres(List.of(genre)).actors(List.of(person)).directors(List.of(person))
            .imdbId("tt123").build();
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
        ShowtimeGroupedDTO showtimeGroupedDTO = modelMapper.showtimeToShowtimeGroupedDTO(showtime);
        assertEquals(showtime.getId(), showtimeGroupedDTO.getShowtimeId());
        assertEquals(showtime.getDateTime(), showtimeGroupedDTO.getDateTime());
        assertEquals(showtime.getTechnology().getName(), showtimeGroupedDTO.getTechnology());
        assertEquals(showtime.getLanguage().name(), showtimeGroupedDTO.getLanguage());
    }

    @Test
    void showtimeNewDTOToShowtime() {
        movie.setId(1L);
        technology.setId(1L);
        when(movieService.findById(1L)).thenReturn(movie);
        when(technologyService.findById(1L)).thenReturn(technology);
        ShowtimeNewDTO showtimeNewDTO = new ShowtimeNewDTO();
        showtimeNewDTO.setMovieId(1L);
        showtimeNewDTO.setDateTime(LocalDateTime.now());
        showtimeNewDTO.setLanguage("DUBBING");
        showtimeNewDTO.setTechnologyId(1L);
        Showtime newShowtime = modelMapper.showtimeNewDTOToShowtime(showtimeNewDTO);

        assertEquals(showtimeNewDTO.getMovieId(), newShowtime.getMovie().getId());
        assertEquals(showtimeNewDTO.getDateTime(), newShowtime.getDateTime());
        assertEquals(showtimeNewDTO.getLanguage(), newShowtime.getLanguage().name());
        assertEquals(showtimeNewDTO.getTechnologyId(), newShowtime.getTechnology().getId());
    }

    @Test
    void movieNewDTOToMovie() {
        person.setId(1L);
        genre.setId(1L);
        MovieNewDTO movieNewDTO = new MovieNewDTO();
        movieNewDTO.setTitle("title");
        movieNewDTO.setShortDescription("shortDesc");
        movieNewDTO.setDescription("desc");
        movieNewDTO.setYearOfProduction(2000);
        movieNewDTO.setDuration(120);
        movieNewDTO.setAgeRestriction(13);
        movieNewDTO.setPosterPath("path");
        movieNewDTO.setImdbId("tt123");
        movieNewDTO.setGenres(List.of(1L));
        movieNewDTO.setDirectors(List.of(1L));
        movieNewDTO.setActors(List.of(1L));

        when(referenceMapper.map(1L, Genre.class)).thenReturn(genre);
        when(referenceMapper.map(1L, Person.class)).thenReturn(person);
        Movie newMovie = modelMapper.movieNewDTOToMovie(movieNewDTO);

        assertEquals(movieNewDTO.getTitle(), newMovie.getTitle());
        assertEquals(movieNewDTO.getGenres().get(0), newMovie.getGenres().get(0).getId());
        assertEquals(movieNewDTO.getActors().get(0), newMovie.getActors().get(0).getId());
        assertEquals(movieNewDTO.getDirectors().get(0), newMovie.getDirectors().get(0).getId());
    }
}
