package com.it.cinemabackend.domain.dto;

import java.time.LocalDateTime;
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
public class ShowtimeNew {

    private Long movieId;
    private LocalDateTime dateTime;
    private Long technologyId;
    private String language;
}
