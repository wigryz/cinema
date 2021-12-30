package com.it.cinemabackend.domain.dto;


import java.util.List;

public record MovieDTO(

    Long id,
    String title,
    String shortDescription,
    String description,
    Integer yearOfProduction,
    Integer duration,
    Integer ageRestriction,
    String posterPath,
    List<GenreDTO> genres,
    List<PersonDTO> directors,
    List<PersonDTO> actors) {
}
