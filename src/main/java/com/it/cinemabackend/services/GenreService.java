package com.it.cinemabackend.services;

import com.it.cinemabackend.model.movie.Genre;
import com.it.cinemabackend.repositories.GenreRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GenreService {

    GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }


    public List<Genre> findAll() {
        List<Genre> genres = new ArrayList<>();
        genreRepository.findAll().forEach(genres::add);
        return genres;
    }
}
