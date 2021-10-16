package com.it.cinemabackend.repository;

import com.it.cinemabackend.domain.model.Technology;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyRepository extends CrudRepository<Technology, Long> {

    List<Technology> findAll();
}
