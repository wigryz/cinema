package com.it.cinemabackend.domain.dto;

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
public class MovieNewDTO {

    private String title;
    private String shortDescription;
    private String description;
    private Integer yearOfProduction;
    private Integer duration;
    private Integer ageRestriction;
    private String posterPath;
    private String imdbId;
    private List<Long> genres;
    private List<Long> directors;
    private List<Long> actors;
}
