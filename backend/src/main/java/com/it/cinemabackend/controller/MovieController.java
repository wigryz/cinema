package com.it.cinemabackend.controller;

import com.it.cinemabackend.mappers.ModelMapper;
import com.it.cinemabackend.model.domain.Genre;
import com.it.cinemabackend.model.domain.Movie;
import com.it.cinemabackend.model.dto.GenreDTO;
import com.it.cinemabackend.model.dto.GenreNewDTO;
import com.it.cinemabackend.model.dto.MovieDTO;
import com.it.cinemabackend.model.dto.MovieNewDTO;
import com.it.cinemabackend.services.GenreService;
import com.it.cinemabackend.services.MovieService;
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
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;
    private final GenreService genreService;
    private final ModelMapper modelMapper;

    public MovieController(MovieService movieService, GenreService genreService, ModelMapper modelMapper) {
        this.movieService = movieService;
        this.genreService = genreService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getMovieById(@PathVariable Long id) {
        MovieDTO movieDTO = modelMapper.movieToMovieDTO(movieService.findById(id));
        return new ResponseEntity<>(movieDTO, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        List<MovieDTO> movieList = movieService.findAll().stream()
            .map(modelMapper::movieToMovieDTO)
            .toList();
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Long> addMovie(@RequestBody MovieNewDTO movieNewDTO) {
        Movie movie = movieService.save(modelMapper.movieNewDTOToMovie(movieNewDTO));
        return new ResponseEntity<>(movie.getId(), HttpStatus.OK);
    }

    @GetMapping("/genres/all")
    public ResponseEntity<List<GenreDTO>> getAllGenres() {
        List<GenreDTO> genreList = genreService.findAll().stream()
            .map(modelMapper::genreToGenreDTO)
            .toList();
        return new ResponseEntity<>(genreList, HttpStatus.OK);
    }

    @PostMapping("/genres/new")
    public ResponseEntity<Long> addGenre(@RequestBody GenreNewDTO genreNewDTO) {
        Genre genre = genreService.save(modelMapper.genreNewDTOToGenre(genreNewDTO));
        return new ResponseEntity<>(genre.getId(), HttpStatus.OK);
    }
}
