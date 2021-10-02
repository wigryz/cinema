package com.it.cinemabackend.services;

import com.it.cinemabackend.model.domain.Genre;
import com.it.cinemabackend.repository.GenreRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GenreService {

    GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    public Genre save(Genre genre) {
        return genreRepository.save(genre);
    }
}
