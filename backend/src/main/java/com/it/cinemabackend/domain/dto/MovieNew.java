package com.it.cinemabackend.domain.dto;

import java.util.List;

public record MovieNew(
    String title,
    String shortDescription,
    String description,
    Integer yearOfProduction,
    Integer duration,
    Integer ageRestriction,
    String posterPath,
    String imdbId,
    List<Long> genres,
    List<Long> directors,
    List<Long> actors) {
}
