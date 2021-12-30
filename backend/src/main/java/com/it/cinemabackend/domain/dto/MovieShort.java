package com.it.cinemabackend.domain.dto;

import java.util.List;

public record MovieShort(

    Integer id,
    String title,
    List<GenreDTO> genres,
    String ageRestriction,
    String duration) {
}
