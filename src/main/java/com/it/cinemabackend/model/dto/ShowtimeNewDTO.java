package com.it.cinemabackend.model.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShowtimeNewDTO {

    private Long movieId;
    private LocalDateTime dateTime;
    private Long technologyId;
    private String language;
}
