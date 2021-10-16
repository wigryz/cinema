package com.it.cinemabackend.domain.mapper;

import com.it.cinemabackend.domain.dto.GenreDTO;
import com.it.cinemabackend.domain.dto.GenreNewDTO;
import com.it.cinemabackend.domain.dto.MovieDTO;
import com.it.cinemabackend.domain.dto.MovieNewDTO;
import com.it.cinemabackend.domain.dto.MovieShortDTO;
import com.it.cinemabackend.domain.dto.PersonDTO;
import com.it.cinemabackend.domain.dto.PersonNewDTO;
import com.it.cinemabackend.domain.dto.ShowtimeDTO;
import com.it.cinemabackend.domain.dto.ShowtimeGroupedDTO;
import com.it.cinemabackend.domain.dto.ShowtimeNewDTO;
import com.it.cinemabackend.domain.dto.TechnologyDTO;
import com.it.cinemabackend.domain.dto.TechnologyNewDTO;
import com.it.cinemabackend.domain.model.Genre;
import com.it.cinemabackend.domain.model.Movie;
import com.it.cinemabackend.domain.model.Person;
import com.it.cinemabackend.domain.model.Showtime;
import com.it.cinemabackend.domain.model.Technology;
import com.it.cinemabackend.service.MovieService;
import com.it.cinemabackend.service.TechnologyService;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component // just to get rid of "no bean of type ... warning"
@Mapper(componentModel = "spring",
    uses = {MovieService.class, TechnologyService.class, ReferenceMapper.class},
    builder = @Builder(disableBuilder = true))
public abstract class ModelMapper {

    @Mapping(source = "movie.id", target = "movieId")
    @Mapping(source = "movie.title", target = "title")
    @Mapping(source = "movie.genres", target = "genres")
    @Mapping(source = "movie.ageRestriction", target = "ageRestriction")
    @Mapping(source = "movie.duration", target = "duration")
    @Mapping(source = "technology.name", target = "technology")
    public abstract ShowtimeDTO showtimeToShowtimeDTO(Showtime showtime);

    public abstract ShowtimeGroupedDTO showtimeToShowtimeGroupedDTO(Showtime showtime);

    @Mapping(source = "movieId", target = "movie")
    @Mapping(source = "technologyId", target = "technology")
    public abstract Showtime showtimeNewDTOToShowtime(ShowtimeNewDTO showtimeNewDTO);

    public abstract MovieShortDTO movieToMovieShortDTO(Movie movie);

    public abstract Movie movieNewDTOToMovie(MovieNewDTO movieNewDTO);

    public abstract MovieDTO movieToMovieDTO(Movie movie);

    public abstract PersonDTO personToPersonDTO(Person person);

    public abstract Person personNewDTOTOPerson(PersonNewDTO personNewDTO);


    public abstract GenreDTO genreToGenreDTO(Genre genre);

    public abstract Genre genreNewDTOToGenre(GenreNewDTO genreNewDTO);

    public abstract Technology technologyNewDTOToTechnology(TechnologyNewDTO technologyNewDTO);

    public abstract TechnologyDTO technologyToTechnologyDTO(Technology technology);

    protected String mapTechnologyToString(Technology technology) {
        return technology.getName();
    }

    public abstract Genre idToGenre(Long id);

    public abstract Person idToPerson(Long id);
}
