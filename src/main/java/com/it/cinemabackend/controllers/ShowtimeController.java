package com.it.cinemabackend.controllers;

import com.it.cinemabackend.mappers.ShowtimeMapper;
import com.it.cinemabackend.model.dto.ShowtimeDTO;
import com.it.cinemabackend.services.ShowtimeService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ShowtimeController {

    private final ShowtimeService showtimeService;
    private final ShowtimeMapper showtimeMapper;
    DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_DATE;

    public ShowtimeController(ShowtimeService showtimeService, ShowtimeMapper showtimeMapper) {
        this.showtimeService = showtimeService;
        this.showtimeMapper = showtimeMapper;
    }

    @GetMapping("/current-showtimes")
    public ResponseEntity<List<ShowtimeDTO>> getCurrentShowtimes() {
        List<ShowtimeDTO> showtimeDTOs = showtimeService.findCurrent().stream()
                .map(showtimeMapper::showtimeToShowtimeDTO).toList();
        return new ResponseEntity<>(showtimeDTOs, HttpStatus.OK);
    }

    @GetMapping("/showtimes/{dateStr}")
    public ResponseEntity<List<ShowtimeDTO>> getShowtimesForTheDay(@PathVariable String dateStr) {
        LocalDate date = LocalDate.parse(dateStr, dateFormatter);
        List<ShowtimeDTO> showtimeDTOs = showtimeService.findByDate(date).stream()
                .map(showtimeMapper::showtimeToShowtimeDTO).toList();
        return new ResponseEntity<>(showtimeDTOs, HttpStatus.OK);
    }

}
