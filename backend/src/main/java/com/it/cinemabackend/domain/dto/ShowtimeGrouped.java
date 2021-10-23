package com.it.cinemabackend.domain.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ShowtimeGrouped {

    private Long showtimeId;
    private LocalDateTime dateTime;
    private String technology;
    private String language;
}
