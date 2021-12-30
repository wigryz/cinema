package com.it.cinemabackend.domain.dto;

public record PersonDTO(

    Long id,
    String firstName,
    String secondName,
    String lastName,
    String portraitPath) {
}
