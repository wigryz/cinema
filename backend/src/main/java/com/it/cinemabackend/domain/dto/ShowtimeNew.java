package com.it.cinemabackend.domain.dto;

import java.time.LocalDateTime;

public record ShowtimeNew(

    Long movieId,
    LocalDateTime dateTime,
    Long technologyId,
    String language) {
}
