package com.it.cinemabackend.mappers;

import com.it.cinemabackend.model.dto.ShowtimeDTO;
import com.it.cinemabackend.model.dto.ShowtimeNewDTO;
import com.it.cinemabackend.model.movie.Genre;
import com.it.cinemabackend.model.movie.Showtime;
import com.it.cinemabackend.services.MovieService;
import com.it.cinemabackend.services.TechnologyService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component // just to get rid of "no bean of type ... warning"
@Mapper(componentModel = "spring", uses = {MovieService.class, TechnologyService.class})
public abstract class ShowtimeMapper {

    @Mapping(source = "showtime.movie.id", target = "movieId")
    @Mapping(source = "showtime.movie.title", target = "title")
    @Mapping(source = "showtime.movie.genres", target = "genres")
    @Mapping(source = "showtime.movie.ageRestriction", target = "ageRestriction")
    @Mapping(source = "showtime.movie.duration", target = "duration")
    @Mapping(source = "showtime.technology.name", target = "technology")
    public abstract ShowtimeDTO showtimeToShowtimeDTO(Showtime showtime);

    @Mapping(source = "movieId", target = "movie")
    @Mapping(source = "dateTime", target = "dateTime")
    @Mapping(source = "technologyId", target = "technology")
    @Mapping(source = "language", target = "language")
    public abstract Showtime showtimeNewDTOToShowtime(ShowtimeNewDTO showtimeNewDTO);

    protected String mapGenreToString(Genre genre) {
        return genre.getName();
    }
}
