package com.it.cinemabackend.controllers;

import com.it.cinemabackend.mappers.ShowtimeMapper;
import com.it.cinemabackend.model.dto.ShowtimeDTO;
import com.it.cinemabackend.model.dto.ShowtimeNewDTO;
import com.it.cinemabackend.model.movie.Showtime;
import com.it.cinemabackend.services.ShowtimeService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/showtimes")
public class ShowtimeController {

    private final ShowtimeService showtimeService;
    private final ShowtimeMapper showtimeMapper;
    DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_DATE;

    public ShowtimeController(ShowtimeService showtimeService, ShowtimeMapper showtimeMapper) {
        this.showtimeService = showtimeService;
        this.showtimeMapper = showtimeMapper;
    }

    @GetMapping("/current")
    public ResponseEntity<List<ShowtimeDTO>> getCurrentShowtimes() {
        List<ShowtimeDTO> showtimeDTOs = showtimeService.findCurrent().stream()
                .map(showtimeMapper::showtimeToShowtimeDTO).toList();
        return new ResponseEntity<>(showtimeDTOs, HttpStatus.OK);
    }

    @GetMapping("/of-date/{dateStr}")
    public ResponseEntity<List<ShowtimeDTO>> getShowtimesForTheDay(@PathVariable String dateStr) {
        LocalDate date = LocalDate.parse(dateStr, dateFormatter);
        List<ShowtimeDTO> showtimeDTOs = showtimeService.findByDate(date).stream()
                .map(showtimeMapper::showtimeToShowtimeDTO).toList();
        return new ResponseEntity<>(showtimeDTOs, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<String> addShowtime(@RequestBody ShowtimeNewDTO showtimeNewDTO) {
        Showtime showtime = showtimeMapper.showtimeNewDTOToShowtime(showtimeNewDTO);
        showtimeService.save(showtime);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
