package com.it.cinemabackend.domain.dto;

import java.time.LocalDateTime;
import java.util.List;

public record ShowtimeDTO(

    Long id,
    Long movieId,
    String title,
    List<GenreDTO> genres,
    Integer ageRestriction,
    Integer duration,
    LocalDateTime dateTime,
    String technology,
    String language) {
}
