package com.it.cinemabackend.model.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ShowtimeGroupedDTO {

    private Long showtimeId;
    private LocalDateTime dateTime;
    private String technology;
    private String language;
}
