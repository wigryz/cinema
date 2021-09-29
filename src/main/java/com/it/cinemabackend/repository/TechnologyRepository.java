package com.it.cinemabackend.repository;

import com.it.cinemabackend.model.movie.Technology;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyRepository extends CrudRepository<Technology, Long> {
}
