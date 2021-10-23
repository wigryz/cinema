package com.it.cinemabackend.domain.mapper;

import com.it.cinemabackend.domain.dto.GenreDTO;
import com.it.cinemabackend.domain.dto.GenreNew;
import com.it.cinemabackend.domain.dto.ImageDTO;
import com.it.cinemabackend.domain.dto.MovieDTO;
import com.it.cinemabackend.domain.dto.MovieNew;
import com.it.cinemabackend.domain.dto.MovieShort;
import com.it.cinemabackend.domain.dto.PersonDTO;
import com.it.cinemabackend.domain.dto.PersonNew;
import com.it.cinemabackend.domain.dto.ShowtimeDTO;
import com.it.cinemabackend.domain.dto.ShowtimeGrouped;
import com.it.cinemabackend.domain.dto.ShowtimeNew;
import com.it.cinemabackend.domain.dto.TechnologyDTO;
import com.it.cinemabackend.domain.dto.TechnologyNew;
import com.it.cinemabackend.domain.model.Genre;
import com.it.cinemabackend.domain.model.Image;
import com.it.cinemabackend.domain.model.Movie;
import com.it.cinemabackend.domain.model.Person;
import com.it.cinemabackend.domain.model.Showtime;
import com.it.cinemabackend.domain.model.Technology;
import com.it.cinemabackend.service.MovieService;
import com.it.cinemabackend.service.TechnologyService;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

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

    public abstract ShowtimeGrouped showtimeToShowtimeGroupedDTO(Showtime showtime);

    @Mapping(source = "movieId", target = "movie")
    @Mapping(source = "technologyId", target = "technology")
    public abstract Showtime showtimeNewToShowtime(ShowtimeNew showtimeNew);

    public abstract MovieShort movieToMovieShortDTO(Movie movie);

    public abstract Movie movieNewToMovie(MovieNew movieNew);

    public abstract MovieDTO movieToMovieDTO(Movie movie);

    public abstract PersonDTO personToPersonDTO(Person person);

    public abstract Person personNewToPerson(PersonNew personNew);

    public abstract ImageDTO imageToImageNoId(Image image);

    public abstract GenreDTO genreToGenreDTO(Genre genre);

    public abstract Genre genreNewToGenre(GenreNew genreNew);

    public abstract Technology technologyNewToTechnology(TechnologyNew technologyNew);

    public abstract TechnologyDTO technologyToTechnologyDTO(Technology technology);

    protected String mapTechnologyToString(Technology technology) {
        return technology.getName();
    }

    public abstract Genre idToGenre(Long id);

    public abstract Person idToPerson(Long id);
}
