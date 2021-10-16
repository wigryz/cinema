package com.it.cinemabackend.mapper;

import com.it.cinemabackend.model.domain.Genre;
import com.it.cinemabackend.model.domain.Movie;
import com.it.cinemabackend.model.domain.Person;
import com.it.cinemabackend.model.domain.Showtime;
import com.it.cinemabackend.model.domain.Technology;
import com.it.cinemabackend.model.dto.GenreDTO;
import com.it.cinemabackend.model.dto.GenreNewDTO;
import com.it.cinemabackend.model.dto.MovieDTO;
import com.it.cinemabackend.model.dto.MovieNewDTO;
import com.it.cinemabackend.model.dto.MovieShortDTO;
import com.it.cinemabackend.model.dto.PersonDTO;
import com.it.cinemabackend.model.dto.PersonNewDTO;
import com.it.cinemabackend.model.dto.ShowtimeDTO;
import com.it.cinemabackend.model.dto.ShowtimeGroupedDTO;
import com.it.cinemabackend.model.dto.ShowtimeNewDTO;
import com.it.cinemabackend.model.dto.TechnologyDTO;
import com.it.cinemabackend.model.dto.TechnologyNewDTO;
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
