package com.it.cinemabackend.controllers;

import com.it.cinemabackend.mappers.ModelMapper;
import com.it.cinemabackend.model.dto.ShowtimeDTO;
import com.it.cinemabackend.model.dto.ShowtimeNewDTO;
import com.it.cinemabackend.model.movie.Showtime;
import com.it.cinemabackend.services.ShowtimeService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger log = LoggerFactory.getLogger(this.getClass());

    private final ShowtimeService showtimeService;
    private final ModelMapper modelMapper;
    DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_DATE;

    public ShowtimeController(ShowtimeService showtimeService, ModelMapper modelMapper) {
        this.showtimeService = showtimeService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/current")
    public ResponseEntity<List<ShowtimeDTO>> getCurrent() {
        List<ShowtimeDTO> showtimeDTOs = showtimeService.findCurrent().stream()
            .map(modelMapper::showtimeToShowtimeDTO)
            .toList();
        return new ResponseEntity<>(showtimeDTOs, HttpStatus.OK);
    }

    @GetMapping("/of-date/{dateStr}")
    public ResponseEntity<List<ShowtimeDTO>> getOfDate(@PathVariable String dateStr) {
        LocalDate date = LocalDate.parse(dateStr, dateFormatter);
        List<ShowtimeDTO> showtimeDTOs = showtimeService.findByDate(date).stream()
            .map(modelMapper::showtimeToShowtimeDTO).toList();
        return new ResponseEntity<>(showtimeDTOs, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<String> add(@RequestBody ShowtimeNewDTO showtimeNewDTO) {
        Showtime showtime = modelMapper.showtimeNewDTOToShowtime(showtimeNewDTO);
        showtime = showtimeService.save(showtime);
        log.info("Added new showtime object to database: {}", showtime);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
