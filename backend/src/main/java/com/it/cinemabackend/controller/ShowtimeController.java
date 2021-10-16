package com.it.cinemabackend.controller;

import com.it.cinemabackend.domain.dto.MovieShortDTO;
import com.it.cinemabackend.domain.dto.ShowtimeDTO;
import com.it.cinemabackend.domain.dto.ShowtimeGroupedDTO;
import com.it.cinemabackend.domain.dto.ShowtimeNewDTO;
import com.it.cinemabackend.domain.dto.TechnologyDTO;
import com.it.cinemabackend.domain.dto.TechnologyNewDTO;
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
    public ResponseEntity<Map<MovieShortDTO, List<ShowtimeGroupedDTO>>> getCurrentGrouped() {
        Map<MovieShortDTO, List<ShowtimeGroupedDTO>> groupedDTOMap =
            groupShowtimeByMovieAndMapToDTO(showtimeService.findCurrent());
        return new ResponseEntity<>(groupedDTOMap, HttpStatus.OK);
    }

    @GetMapping("/showtime/of-date-grouped/{dateStr}")
    public ResponseEntity<Map<MovieShortDTO, List<ShowtimeGroupedDTO>>> getCurrentGrouped(@PathVariable String dateStr) {
        LocalDate date = LocalDate.parse(dateStr, dateFormatter);
        Map<MovieShortDTO, List<ShowtimeGroupedDTO>> groupedDTOMap =
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
    public ResponseEntity<String> add(@RequestBody ShowtimeNewDTO showtimeNewDTO) {
        Showtime showtime = modelMapper.showtimeNewDTOToShowtime(showtimeNewDTO);
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

    @GetMapping("/technology/new")
    public ResponseEntity<Long> addTechnology(@RequestBody TechnologyNewDTO technologyNewDTO) {
        Technology technology =
            technologyService.save(modelMapper.technologyNewDTOToTechnology(technologyNewDTO));
        return new ResponseEntity<>(technology.getId(), HttpStatus.OK);
    }

    private Map<MovieShortDTO, List<ShowtimeGroupedDTO>>
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
