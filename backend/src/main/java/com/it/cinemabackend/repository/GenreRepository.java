package com.it.cinemabackend.repository;

import com.it.cinemabackend.domain.model.Genre;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Long> {

    List<Genre> findAll();
}
