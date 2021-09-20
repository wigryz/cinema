package com.it.cinemabackend.repository;

import com.it.cinemabackend.model.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
