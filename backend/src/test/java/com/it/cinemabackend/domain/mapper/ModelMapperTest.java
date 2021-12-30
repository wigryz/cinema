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
                     .genres(List.of(genre)).actors(List.of(person)).directors(List.of(person))
                     .build();
        person.setMoviesAsActor(List.of(movie));
        person.setMoviesAsDirector(List.of(movie));
        showtime = Showtime.builder().movie(movie).dateTime(LocalDateTime.now())
                           .technology(technology).language(Language.DUBBING).build();
    }

    @Test
    void showtimeToShowtimeDTO() {
        ShowtimeDTO showtimeDTO = modelMapper.showtimeToShowtimeDTO(showtime);
        assertEquals(showtime.getId(), showtimeDTO.id());
        assertEquals(showtime.getMovie().getId(), showtimeDTO.movieId());
        assertEquals(showtime.getMovie().getTitle(), showtimeDTO.title());
        assertEquals(showtime.getMovie().getGenres().stream().map(Genre::getId).toList(),
                     showtimeDTO.genres().stream().map(GenreDTO::id).toList());
        assertEquals(showtime.getMovie().getAgeRestriction(), showtimeDTO.ageRestriction());
        assertEquals(showtime.getDateTime(), showtimeDTO.dateTime());
        assertEquals(showtime.getTechnology().getName(), showtimeDTO.technology());
        assertEquals(showtime.getLanguage().name(), showtimeDTO.language());
    }

    @Test
    void showtimeToShowtimeGroupedDTO() {
        ShowtimeGrouped showtimeGrouped = modelMapper.showtimeToShowtimeGroupedDTO(showtime);
        assertEquals(showtime.getId(), showtimeGrouped.showtimeId());
        assertEquals(showtime.getDateTime(), showtimeGrouped.dateTime());
        assertEquals(showtime.getTechnology().getName(), showtimeGrouped.technology());
        assertEquals(showtime.getLanguage().name(), showtimeGrouped.language());
    }

    @Test
    void showtimeNewDTOToShowtime() {
        movie.setId(1L);
        technology.setId(1L);
        when(movieService.findById(1L)).thenReturn(movie);
        when(technologyService.findById(1L)).thenReturn(technology);
        ShowtimeNew showtimeNew = new ShowtimeNew(1L, LocalDateTime.now(), 1L, "DUBBING");
        Showtime newShowtime = modelMapper.showtimeNewToShowtime(showtimeNew);

        assertEquals(showtimeNew.movieId(), newShowtime.getMovie().getId());
        assertEquals(showtimeNew.dateTime(), newShowtime.getDateTime());
        assertEquals(showtimeNew.language(), newShowtime.getLanguage().name());
        assertEquals(showtimeNew.technologyId(), newShowtime.getTechnology().getId());
    }

    @Test
    void movieNewDTOToMovie() {
        person.setId(1L);
        genre.setId(1L);
        MovieNew movieNew = new MovieNew("title", "shortDesc", "desc", 2000, 120, 13, "path",
                                         "tt123", List.of(1L), List.of(1L), List.of(1L));

        when(referenceMapper.map(1L, Genre.class)).thenReturn(genre);
        when(referenceMapper.map(1L, Person.class)).thenReturn(person);
        Movie newMovie = modelMapper.movieNewToMovie(movieNew);

        assertEquals(movieNew.title(), newMovie.getTitle());
        assertEquals(movieNew.genres().get(0), newMovie.getGenres().get(0).getId());
        assertEquals(movieNew.actors().get(0), newMovie.getActors().get(0).getId());
        assertEquals(movieNew.directors().get(0), newMovie.getDirectors().get(0).getId());
    }
}
