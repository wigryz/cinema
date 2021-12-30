package com.it.cinemabackend.domain.dto;

public record ImageDTO(

    String name,
    String type,
    byte[] content) {
}
