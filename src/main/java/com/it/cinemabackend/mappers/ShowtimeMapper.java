package com.it.cinemabackend.mappers;

import com.it.cinemabackend.model.dto.ShowtimeDTO;
import com.it.cinemabackend.model.movie.Genre;
import com.it.cinemabackend.model.movie.Showtime;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class ShowtimeMapper {

    @Mapping(source = "showtime.movie.id", target = "movieId")
    @Mapping(source = "showtime.movie.title", target = "title")
    @Mapping(source = "showtime.movie.genres", target = "genres")
    @Mapping(source = "showtime.movie.ageRestriction", target = "ageRestriction")
    @Mapping(source = "showtime.movie.duration", target = "duration")
    @Mapping(source = "showtime.technology.name", target = "technology")
    public abstract ShowtimeDTO showtimeToShowtimeDTO(Showtime showtime);

    protected String mapGenreToString(Genre genre) {
        return genre.getName();
    }
}
