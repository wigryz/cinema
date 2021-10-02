package com.it.cinemabackend.repository;

import com.it.cinemabackend.model.movie.Movie;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

    Optional<Movie> findById(Long id);
}
