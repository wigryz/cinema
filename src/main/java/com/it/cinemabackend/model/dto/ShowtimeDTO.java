package com.it.cinemabackend.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ShowtimeDTO {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("movieId")
    private Integer movieId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("genres")
    private List<String> genres;

    @JsonProperty("ageRestriction")
    private String ageRestriction;

    @JsonProperty("duration")
    private String duration;

    @JsonProperty("dateTime")
    private LocalDateTime dateTime;

    @JsonProperty("technology")
    private String technology;

    @JsonProperty("language")
    private String language;
}
