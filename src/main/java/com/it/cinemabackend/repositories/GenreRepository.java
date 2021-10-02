package com.it.cinemabackend.repositories;

import com.it.cinemabackend.model.movie.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Long> {
}
