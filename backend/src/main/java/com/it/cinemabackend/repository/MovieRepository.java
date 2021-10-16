package com.it.cinemabackend.repository;

import com.it.cinemabackend.domain.model.Movie;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

    List<Movie> findAll();
}
