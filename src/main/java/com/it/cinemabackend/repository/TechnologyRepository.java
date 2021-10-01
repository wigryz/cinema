package com.it.cinemabackend.repository;

import com.it.cinemabackend.model.movie.Technology;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyRepository extends CrudRepository<Technology, Long> {

    Optional<Technology> findById(Long id);
}
