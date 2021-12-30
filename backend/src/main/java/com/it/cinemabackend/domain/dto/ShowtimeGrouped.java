package com.it.cinemabackend.domain.dto;

import java.time.LocalDateTime;

public record ShowtimeGrouped(

    Long showtimeId,
    LocalDateTime dateTime,
    String technology,
    String language) {
}
