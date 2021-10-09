package com.it.cinemabackend.model.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MovieDTO {

    private Long id;
    private String title;
    private String shortDescription;
    private String description;
    private Integer yearOfProduction;
    private Integer duration;
    private Integer ageRestriction;
    private String posterPath;
    private String imdbId;
    private List<GenreDTO> genres;
    private List<PersonDTO> directors;
    private List<PersonDTO> actors;
}
