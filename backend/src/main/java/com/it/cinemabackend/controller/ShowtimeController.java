package com.it.cinemabackend.controller;

import com.it.cinemabackend.domain.dto.MovieShort;
import com.it.cinemabackend.domain.dto.ShowtimeDTO;
import com.it.cinemabackend.domain.dto.ShowtimeGrouped;
import com.it.cinemabackend.domain.dto.ShowtimeNew;
import com.it.cinemabackend.domain.dto.TechnologyDTO;
import com.it.cinemabackend.domain.dto.TechnologyNew;
import com.it.cinemabackend.domain.mapper.ModelMapper;
import com.it.cinemabackend.domain.model.Movie;
import com.it.cinemabackend.domain.model.Showtime;
import com.it.cinemabackend.domain.model.Technology;
import com.it.cinemabackend.service.ShowtimeService;
import com.it.cinemabackend.service.TechnologyService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
@Slf4j
public class ShowtimeController {

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_DATE;
    private final ShowtimeService showtimeService;
    private final TechnologyService technologyService;
    private final ModelMapper modelMapper;

    public ShowtimeController(ShowtimeService showtimeService, TechnologyService technologyService, ModelMapper modelMapper) {
        this.showtimeService = showtimeService;
        this.technologyService = technologyService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/showtime/current")
    public ResponseEntity<List<ShowtimeDTO>> getCurrent() {
        List<ShowtimeDTO> showtimeDTOs = showtimeService.findCurrent().stream()
            .map(modelMapper::showtimeToShowtimeDTO)
            .toList();
        return new ResponseEntity<>(showtimeDTOs, HttpStatus.OK);
    }

    @GetMapping("/showtime/current-grouped")
    public ResponseEntity<Map<MovieShort, List<ShowtimeGrouped>>> getCurrentGrouped() {
        Map<MovieShort, List<ShowtimeGrouped>> groupedDTOMap =
            groupShowtimeByMovieAndMapToDTO(showtimeService.findCurrent());
        return new ResponseEntity<>(groupedDTOMap, HttpStatus.OK);
    }

    @GetMapping("/showtime/of-date-grouped/{dateStr}")
    public ResponseEntity<Map<MovieShort, List<ShowtimeGrouped>>> getCurrentGrouped(@PathVariable String dateStr) {
        LocalDate date = LocalDate.parse(dateStr, dateFormatter);
        Map<MovieShort, List<ShowtimeGrouped>> groupedDTOMap =
            groupShowtimeByMovieAndMapToDTO(showtimeService.findByDate(date));
        return new ResponseEntity<>(groupedDTOMap, HttpStatus.OK);
    }

    @GetMapping("/showtime/of-date/{dateStr}")
    public ResponseEntity<List<ShowtimeDTO>> getOfDate(@PathVariable String dateStr) {
        LocalDate date = LocalDate.parse(dateStr, dateFormatter);
        List<ShowtimeDTO> showtimeDTOs = showtimeService.findByDate(date).stream()
            .map(modelMapper::showtimeToShowtimeDTO).toList();
        return new ResponseEntity<>(showtimeDTOs, HttpStatus.OK);
    }

    @GetMapping("/showtime/of-movie/{movieId}")
    public ResponseEntity<List<ShowtimeDTO>> getOfMovie(@PathVariable Long movieId) {
        List<ShowtimeDTO> showtimeDTOs = showtimeService.findByMovieId(movieId).stream()
            .map(modelMapper::showtimeToShowtimeDTO).toList();
        return new ResponseEntity<>(showtimeDTOs, HttpStatus.OK);
    }

    @PostMapping("/showtime")
    public ResponseEntity<String> add(@RequestBody ShowtimeNew showtimeNew) {
        Showtime showtime = modelMapper.showtimeNewToShowtime(showtimeNew);
        showtime = showtimeService.save(showtime);
        log.info("Added new showtime object to database: {}", showtime);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/technology/all")
    public ResponseEntity<List<TechnologyDTO>> getAllTechnologies() {
        List<TechnologyDTO> technologyDTOs = technologyService.findAll().stream()
            .map(modelMapper::technologyToTechnologyDTO)
            .toList();
        return new ResponseEntity<>(technologyDTOs, HttpStatus.OK);
    }

    @PostMapping("/technology")
    public ResponseEntity<Long> addTechnology(@RequestBody TechnologyNew technologyNew) {
        Technology technology =
            technologyService.save(modelMapper.technologyNewToTechnology(technologyNew));
        return new ResponseEntity<>(technology.getId(), HttpStatus.OK);
    }

    private Map<MovieShort, List<ShowtimeGrouped>>
    groupShowtimeByMovieAndMapToDTO(List<Showtime> showtimeList) {
        Map<Movie, List<Showtime>> movieShowtimesMap =
            showtimeList.stream().collect(Collectors.groupingBy(Showtime::getMovie));
        return movieShowtimesMap.entrySet().stream().collect(Collectors.toMap(
            k -> modelMapper.movieToMovieShortDTO(k.getKey()),
            v -> v.getValue().stream()
                .map(modelMapper::showtimeToShowtimeGroupedDTO)
                .toList()));
    }
}
