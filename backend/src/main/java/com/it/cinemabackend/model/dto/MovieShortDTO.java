package com.it.cinemabackend.model.dto;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MovieShortDTO {

    private Integer id;
    private String title;
    private List<GenreDTO> genres;
    private String ageRestriction;
    private String duration;
}
